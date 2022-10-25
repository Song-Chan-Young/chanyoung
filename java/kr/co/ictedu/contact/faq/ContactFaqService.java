package kr.co.ictedu.contact.faq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ictedu.util.dto.MemberDTO;
import kr.co.ictedu.util.dto.SearchDTO;

@Service
public class ContactFaqService {

	@Autowired
	private ContactFaqDAO dao;

	public int update( ContactFaqDTO dto ) {
		int successCount = 0;
		successCount = dao.update( dto );
		return successCount;
	}//update

	public int delete( ContactFaqDTO dto ) {
		int successCount = 0;
		successCount = dao.delete( dto );
		return successCount;
	}//delete

	public ContactFaqDTO detail( String board_no ) {
		dao.incrementViewCnt( board_no );

		ContactFaqDTO dto = null;
		dto = dao.detail( board_no );
		return dto;
	}//detail

	public int write( ContactFaqDTO dto ) {
		int successCount = 0;
		successCount = dao.write( dto );
		return successCount;
	}//write

	public List<ContactFaqDTO> searchList( SearchDTO dto ) {
		List<ContactFaqDTO> list = null;
		list = dao.searchList( dto );
		return list;
	}//searchList

	public int searchListCount( SearchDTO dto ) {
		int totalCount = 0;
		totalCount = dao.searchListCount( dto );
		return totalCount;
	}//searchListCount

}//class






