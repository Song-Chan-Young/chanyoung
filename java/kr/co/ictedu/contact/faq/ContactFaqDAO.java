package kr.co.ictedu.contact.faq;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.co.ictedu.util.dto.SearchDTO;

@Repository
public class ContactFaqDAO {

	@Autowired
	private SqlSession sqlSession;

	public int update( ContactFaqDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.update("ContactFaqMapper.update", dto);
		return successCount;
	}//update

	public int delete( ContactFaqDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.delete("ContactFaqMapper.delete", dto);
		return successCount;
	}//delete

	public void incrementViewCnt( String board_no ) {
		sqlSession.update("ContactFaqMapper.incrementViewCnt", board_no);
	}//incrementViewCnt

	public ContactFaqDTO detail( String board_no ) {
		ContactFaqDTO dto = null;
		dto = sqlSession.selectOne("ContactFaqMapper.detail", board_no);
		return dto;
	}//detail

	public int write( ContactFaqDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("ContactFaqMapper.write", dto);
		return successCount;
	}//write
	
	public List<ContactFaqDTO> searchList( SearchDTO dto ) {
		List<ContactFaqDTO> list = null;
		System.out.println(dto);
		list = sqlSession.selectList("ContactFaqMapper.selectList", dto);
		System.out.println(list);
		return list;
	}//searchList


	public int searchListCount( SearchDTO dto ) {
		int totalCount = 0;
		totalCount = sqlSession.selectOne("ContactFaqMapper.searchListCount", dto);
		return totalCount;
	}//searchListCount

}//class








