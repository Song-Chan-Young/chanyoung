package kr.co.ictedu.getshare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ictedu.util.dto.SearchDTO;

@Service
public class GetShareService {

	@Autowired
	private GetShareDAO dao;

	public int fileDelete( GetShareDTO dto ) {
		int successCount = 0;
		successCount = dao.fileDelete( dto );
		return successCount;
	}//fileDelete

	public int update( GetShareDTO dto ) {
		int successCount = 0;
		successCount = dao.update( dto );
		return successCount;
	}//update

	public int delete( GetShareDTO dto ) {
		int successCount = 0;
		successCount = dao.delete( dto );
		return successCount;
	}//delete

	public GetShareDTO detail( String prdt_no ) {
		dao.incrementViewCnt( prdt_no );

		GetShareDTO dto = null;
		dto = dao.detail( prdt_no );
		return dto;
	}//detail

	public List<GetShareDTO> searchList( SearchDTO dto ) {
		List<GetShareDTO> list = null;
		if (dto.getMain_page_yn() == 1) {
			list = dao.searchListByMainPage( dto );
		} else {
			list = dao.searchList( dto );
		}
		return list;
	}//searchList

	public int searchListCount( SearchDTO dto ) {
		int totalCount = 0;
		if (dto.getMain_page_yn() == 1) {
			totalCount = dao.searchListCountByMainPage( dto );
		} else {
			totalCount = dao.searchListCount( dto );
		}
		return totalCount;
	}//searchListCount

	public int insert( GetShareDTO dto ) {
		int successCount = 0;
		successCount = dao.insert(dto);
		return successCount;
	}//insert

}//class
