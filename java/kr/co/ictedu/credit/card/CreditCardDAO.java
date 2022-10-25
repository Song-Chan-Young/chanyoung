package kr.co.ictedu.credit.card;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreditCardDAO {

	@Autowired
	private SqlSession sqlSession;

	public int delete( CreditCardDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.update("CreditCardMapper.delete", dto);
		return successCount;
	}//delete

	public int insert( CreditCardDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("CreditCardMapper.insert", dto);
		return successCount;
	}//insert

	public List<CreditCardDTO> list( String mno ) {
		List<CreditCardDTO> list = null;
		list = sqlSession.selectList("CreditCardMapper.list", mno);
		return list;
	}//list

}//class
