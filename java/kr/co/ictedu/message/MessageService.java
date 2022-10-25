package kr.co.ictedu.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ictedu.credit.card.CreditCardDTO;
import kr.co.ictedu.util.dto.SearchDTO;

@Service
public class MessageService{

	@Autowired
	private MessageDAO dao;

	public int delete( MessageDTO dto ) {
		int successCount = 0;
		successCount = dao.delete( dto );
		successCount = dao.deleteChat( dto );
		return successCount;
	}//delete
	
	
	
	public int chat( MessageDTO dto ) {
		int successCount = 0;
		successCount = dao.chat( dto );
		return successCount;
	}//write
	

	public List<MessageDTO> chatList( MessageDTO dto ) {
		List<MessageDTO> list = null;
		list = dao.chatList( dto );
		return list;
	}//list
	

	public int makeMemoRoom( MessageDTO dto ) {
		int successCount = 0;
		successCount = dao.makeMemoRoom( dto );
		return successCount;
	}//makeMemoRoom

	public List<MessageDTO> searchList( SearchDTO dto ) {
		List<MessageDTO> list = null;
		list = dao.searchList( dto );
		return list;
	}//searchList

	public int searchListCount( SearchDTO dto ) {
		int totalCount = 0;
		totalCount = dao.searchListCount( dto );
		return totalCount;
	}//searchListCount

}//class
