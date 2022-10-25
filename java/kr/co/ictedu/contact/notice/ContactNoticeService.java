package kr.co.ictedu.contact.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ictedu.util.dto.MemberDTO;
import kr.co.ictedu.util.dto.SearchDTO;

@Service
public class ContactNoticeService {

	@Autowired
	private ContactNoticeDAO dao;

	public int update( ContactNoticeDTO dto ) {
		int successCount = 0;
		successCount = dao.update( dto );
		return successCount;
	}//update

	public int delete( ContactNoticeDTO dto ) {
		int successCount = 0;
		successCount = dao.delete( dto );
		return successCount;
	}//delete

	public ContactNoticeDTO detail( String board_no ) {
		dao.incrementViewCnt( board_no );

		ContactNoticeDTO dto = null;
		dto = dao.detail( board_no );
		return dto;
	}//detail

	public int write( ContactNoticeDTO dto ) {
		int successCount = 0;
		successCount = dao.write( dto );
		return successCount;
	}//write

	public List<ContactNoticeDTO> searchList( SearchDTO dto ) {
		List<ContactNoticeDTO> list = null;
		list = dao.searchList( dto );
		return list;
	}//searchList

	public int searchListCount( SearchDTO dto ) {
		int totalCount = 0;
		totalCount = dao.searchListCount( dto );
		return totalCount;
	}//searchListCount

}//class






