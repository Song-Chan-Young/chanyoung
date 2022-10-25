package kr.co.ictedu.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ictedu.getshare.GetShareDTO;

@Repository
public class CartDAO {

	@Autowired
	private SqlSession sqlSession;

	public int updateBuyQty( GetShareDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.delete("CartMapper.updateBuyQty", dto);
		return successCount;
	}//updateBuyQty

	public int delete( GetShareDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.delete("CartMapper.delete", dto);
		return successCount;
	}//delete

	public List<GetShareDTO> list(String mno) {
		List<GetShareDTO> list = null;
		list = sqlSession.selectList("CartMapper.list", mno);
		return list;
	}//list

	public int insert(GetShareDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("CartMapper.insert", dto);
		return successCount;
	}//insert

}//class
