package kr.co.ictedu.cart;

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

import kr.co.ictedu.getshare.GetShareDTO;
import kr.co.ictedu.util.dto.MemberDTO;

@Controller
@RequestMapping( value = "/cart" )
public class CartController {

	private final static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService service;

	@RequestMapping( value = "/update_buy_qty", method = RequestMethod.GET )
	public void updateBuyQty( GetShareDTO dto, HttpSession session, PrintWriter out ) {
		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		int successCount = 0;
		successCount = service.updateBuyQty( dto );
		out.print(successCount);
		out.close();
	}//updateBuyQty

	@RequestMapping( value = "/delete", method = RequestMethod.GET )
	public void delete( GetShareDTO dto, HttpSession session, PrintWriter out ) {
		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		int successCount = 0;
		successCount = service.delete( dto );
		out.print(successCount);
		out.close();
	}//delete

	@RequestMapping( value = "/list", method = RequestMethod.GET )
	public String list( Model model, HttpSession session ) {
		String mno = ( (MemberDTO) session.getAttribute("login_info") ).getMno();

		List<GetShareDTO> list = null;
		list = service.list( mno );
		model.addAttribute("list", list);
		return "/cart/list";//jsp file name
	}//list

	@RequestMapping( value = "/insert", method = RequestMethod.POST )
	public void insert( GetShareDTO dto, HttpSession session, PrintWriter out ) {
		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		int successCount = 0;
		successCount = service.insert(dto);
		out.print(successCount);
		out.close();
	}//insert

}//class

/*
drop table cart;

create table cart (
  cart_no int not null auto_increment,
  mno int not null,
  prdt_no int not null,
  buy_qty int not null,
  reg_date datetime not null,
  primary key (cart_no)
);
*/
