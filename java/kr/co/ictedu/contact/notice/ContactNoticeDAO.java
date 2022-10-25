package kr.co.ictedu.contact.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.co.ictedu.util.dto.SearchDTO;

@Repository
public class ContactNoticeDAO {

	@Autowired
	private SqlSession sqlSession;

	public int update( ContactNoticeDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.update("ContactNoticeMapper.update", dto);
		return successCount;
	}//update

	public int delete( ContactNoticeDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.delete("ContactNoticeMapper.delete", dto);
		return successCount;
	}//delete

	public void incrementViewCnt( String board_no ) {
		sqlSession.update("ContactNoticeMapper.incrementViewCnt", board_no);
	}//incrementViewCnt

	public ContactNoticeDTO detail( String board_no ) {
		ContactNoticeDTO dto = null;
		dto = sqlSession.selectOne("ContactNoticeMapper.detail", board_no);
		return dto;
	}//detail

	public int write( ContactNoticeDTO dto) {
		int successCount = 0;
		System.out.println(dto);
		successCount = sqlSession.insert("ContactNoticeMapper.write", dto);
		System.out.println(successCount);
		return successCount;
	}//write
	
	public List<ContactNoticeDTO> searchList( SearchDTO dto ) {
		List<ContactNoticeDTO> list = null;
		System.out.println(dto);
		list = sqlSession.selectList("ContactNoticeMapper.selectList", dto);
		System.out.println(list);
		return list;
	}//searchList


	public int searchListCount( SearchDTO dto ) {
		int totalCount = 0;
		totalCount = sqlSession.selectOne("ContactNoticeMapper.searchListCount", dto);
		return totalCount;
	}//searchListCount

}//class








