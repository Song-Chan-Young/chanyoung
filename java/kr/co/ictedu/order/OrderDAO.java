package kr.co.ictedu.order;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ictedu.getshare.GetShareDTO;

@Repository
public class OrderDAO {

	@Autowired
	private SqlSession sqlSession;

	

	public int updateCreditCardUsedDate( OrderMainDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.update("OrderMapper.updateCreditCardUsedDate", dto);
		return successCount;
	}//updateCreditCardUsedDate

	public int deleteCartByArray(String [] arr_cart_no) {
		int successCount = 0;
		successCount = sqlSession.delete("OrderMapper.deleteCartByArray", arr_cart_no);
		return successCount;
	}//deleteCartByArray

	public int insertBuyNowOrderDetail(OrderMainDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("OrderMapper.insertBuyNowOrderDetail", dto);
		return successCount;
	}//insertOrderDetail

	public int insertOrderDetail(OrderMainDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("OrderMapper.insertOrderDetail", dto);
		return successCount;
	}//insertOrderDetail

	public int insertOrderMain(OrderMainDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("OrderMapper.insertOrderMain", dto);
		return successCount;
	}//insertOrderMain

	public List<GetShareDTO> buyNowOrderList(GetShareDTO dto) {
		List<GetShareDTO> list = null;
		list = sqlSession.selectList("OrderMapper.buyNowOrderList", dto);
		return list;
	}//buyNowOrderList

	public List<GetShareDTO> orderList(String [] arr_cart_no) {
		List<GetShareDTO> list = null;
		list = sqlSession.selectList("OrderMapper.orderList", arr_cart_no);
		return list;
	}//orderList

}//class
