package kr.co.ictedu.getshare;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ictedu.util.dto.SearchDTO;

@Repository
public class GetShareDAO {

	@Autowired
	private SqlSession sqlSession;

	public int fileDelete( GetShareDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.update("GetShareMapper.fileDelete", dto);
		return successCount;
	}//delete

	public int update( GetShareDTO dto ) {
		int successCount = 0;
		System.out.println(dto);
		successCount = sqlSession.update("GetShareMapper.update", dto);
		System.out.println(successCount);
		return successCount;
	}//update

	public int delete( GetShareDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.update("GetShareMapper.delete", dto);
		return successCount;
	}//delete

	public void incrementViewCnt( String prdt_no ) {
		sqlSession.update("GetShareMapper.incrementViewCnt", prdt_no);
	}//incrementViewCnt

	public GetShareDTO detail( String prdt_no ) {
		GetShareDTO dto = null;
		dto = sqlSession.selectOne("GetShareMapper.detail", prdt_no);
		return dto;
	}//detail

	public List<GetShareDTO> searchList( SearchDTO dto ) {
		List<GetShareDTO> list = null;
		list = sqlSession.selectList("GetShareMapper.selectList", dto);
		return list;
	}//searchList

	public int searchListCount( SearchDTO dto ) {
		int totalCount = 0;
		totalCount = sqlSession.selectOne("GetShareMapper.searchListCount", dto);
		return totalCount;
	}//searchListCount
	
	public List<GetShareDTO> searchListByMainPage( SearchDTO dto ) {
		List<GetShareDTO> list = null;
		list = sqlSession.selectList("GetShareMapper.searchListByMainPage", dto);
		return list;
	}//searchListByMainPage

	public int searchListCountByMainPage( SearchDTO dto ) {
		int totalCount = 0;
		totalCount = sqlSession.selectOne("GetShareMapper.searchListCountByMainPage", dto);
		return totalCount;
	}//searchListCountByMainPage
	
	

	public int insert(GetShareDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("GetShareMapper.insert", dto);
		return successCount;
	}//insert

}//class
