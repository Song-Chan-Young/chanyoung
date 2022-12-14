package kr.co.ictedu.order;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ictedu.getshare.GetShareDTO;

@Service
public class OrderService {

	@Autowired
	private OrderDAO dao;

	@Transactional
	public int insert( OrderMainDTO dto, int buyNowYN ) {
		int successCount = 0;
		successCount = dao.insertOrderMain(dto);//insertOrderMain을 호출하는 시점에서는 dto에 order_no 값이 없다.
		//insertOrderMain을 수행하면서 selectKey가 dto에 order_no 값을 입력한다.
		if(successCount < 1) return successCount;

		if(buyNowYN == 0) {
			successCount = dao.insertOrderDetail(dto);//insertOrderDetail을 호출하는 시점에서는 dto에 order_no 값이 있다.
			if(successCount < 1) return successCount;

			successCount = dao.deleteCartByArray(dto.getArr_cart_no());
		} else if(buyNowYN == 1) {//장바구니 테이블에 데이터가 없는 바로 주문
			successCount = dao.insertBuyNowOrderDetail(dto);
		}
		if(successCount < 1) return successCount;

		successCount = dao.updateCreditCardUsedDate(dto);
		if(successCount < 1) return successCount;

		return successCount;
	}//insert

	public List<GetShareDTO> buyNowOrderList(GetShareDTO dto) {
		List<GetShareDTO> list = null;
		list = dao.buyNowOrderList(dto);
		return list;
	}//buyNowOrderList

	public List<GetShareDTO> orderList(String [] arr_cart_no) {
		List<GetShareDTO> list = null;
		list = dao.orderList(arr_cart_no);
		return list;
	}//orderList

}//class
