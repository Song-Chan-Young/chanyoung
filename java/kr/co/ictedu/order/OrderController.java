package kr.co.ictedu.order;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import kr.co.ictedu.cart.CartController;
import kr.co.ictedu.credit.card.CreditCardDTO;
import kr.co.ictedu.credit.card.CreditCardService;
import kr.co.ictedu.getshare.GetShareDTO;
import kr.co.ictedu.util.dto.MemberDTO;

@Controller
@RequestMapping( value = "/order" )
public class OrderController {

	private final static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private OrderService service;

	
	@Autowired
	private CreditCardService creditCardService;

	@RequestMapping( value = "/insert", method = RequestMethod.POST )
	public void insert( OrderMainDTO dto, HttpSession session, PrintWriter out ) {
		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		String [] tmpArr = dto.getStr_cart_no().split(",");
		dto.setArr_cart_no(tmpArr);

		int successCount = 0;
		if(dto.getArr_cart_no().length == 1 && dto.getArr_cart_no()[0].equals("0")) {
			//arr_cart_no의 길이가 1이고, arr_cart_no의 [0]번지의 값이 "0"이면, 장바구니 테이블에 데이터가 없는 바로 주문이다.
			successCount = service.insert(dto, 1);
		} else {
			successCount = service.insert(dto, 0);
		}
		out.print(successCount);
		out.close();
	}//insert

	@RequestMapping( value = "/order_list", method = RequestMethod.GET )
	public String orderList( String [] arr_cart_no, GetShareDTO dto, Model model, HttpSession session ) {
		List<GetShareDTO> list = null;
		if(arr_cart_no != null && arr_cart_no.length > 0) {//장바구니 -> 주문 목록
			list = service.orderList( arr_cart_no );
		} else {//상품 상세 화면 바로구매버튼 -> 주문 목록
			list = service.buyNowOrderList( dto );
			arr_cart_no = new String[1];
			arr_cart_no[0] = "0";
		}
		model.addAttribute("list", list);

		List<CreditCardDTO> cardlist = null;
		cardlist = creditCardService.list( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );
		model.addAttribute("cardlist", cardlist);

		model.addAttribute( "arr_cart_no", new Gson().toJson( arr_cart_no ) );

		return "/order/order_list";//jsp file name
	}//orderList

}//class

/*
drop table order_main;

create table order_main (
  order_no int not null auto_increment,
  mno int not null,
  card_no int not null,
  order_product_cnt int not null,
  order_amt int not null,
  pay_amt int not null,
  order_date datetime not null,
  order_status int default '3',
  primary key (order_no)
);

 -- order_no -- 주문번호
 -- mno -- 멤버번호
 -- card_no -- 카드번호
 -- order_product_cnt -- 주문상품수
 -- order_amt -- 주문금액
 -- pay_amt -- 결제금액
 -- order_date -- 주문일자
 -- order_status -- 주문상태
 -- 주문상태(1:주문완료, 3:결제완료, 5:판매자확인완료,  13:구매자구매확정완료, 15:자동구매결정완료)
 -- 결제사 연동이 없으므로, (3:결제완료, 5:판매자확인완료, 13:구매자구매확정완료, 15:자동구매결정완료)만 구현한다.

drop table order_detail;

create table order_detail (
  detail_no int not null auto_increment,
  order_no int not null,
  prdt_no int not null,
  detail_qty int not null,
  detail_price int not null,
  detail_amt int not null,
  detail_pay_amt int not null,
  primary key (detail_no)
);

 -- detail_no -- 주문상세번호
 -- order_no -- 주문번호
 -- prod_no -- 상품번호
 -- detail_qty -- 주문수량
 -- detail_price -- 판매단가
 -- detail_amt -- 주문금액 (주문수량 * 판매단가)
 -- detail_pay_amt -- 결제금액

drop table common_code;

create table common_code (
  code_no int not null,
  code_class varchar(30) not null,
  code_name varchar(60) not null
);

insert into common_code (code_no, code_class, code_name)
values (1, 'order_status', '주문완료')
, (3, 'order_status', '결제완료')
, (5, 'order_status', '판매자확인완료')
, (13, 'order_status', '구매자구매확정완료')
, (15, 'order_status', '자동구매결정완료');
*/