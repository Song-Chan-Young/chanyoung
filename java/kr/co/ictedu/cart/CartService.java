package kr.co.ictedu.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ictedu.getshare.GetShareDTO;

@Service
public class CartService {

	@Autowired
	private CartDAO dao;

	public int updateBuyQty( GetShareDTO dto ) {
		int successCount = 0;
		successCount = dao.updateBuyQty( dto );
		return successCount;
	}//updateBuyQty

	public int delete( GetShareDTO dto ) {
		int successCount = 0;
		successCount = dao.delete( dto );
		return successCount;
	}//delete

	public List<GetShareDTO> list(String mno) {
		List<GetShareDTO> list = null;
		list = dao.list(mno);
		return list;
	}//list

	public int insert( GetShareDTO dto ) {
		int successCount = 0;
		successCount = dao.insert(dto);
		return successCount;
	}//insert

}//class
