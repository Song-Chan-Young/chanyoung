package kr.co.ictedu.message;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ictedu.credit.card.CreditCardDTO;
import kr.co.ictedu.util.dto.SearchDTO;

@Repository
public class MessageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
	public int deleteChat( MessageDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.delete("MessageMapper.deleteChat", dto);
		return successCount;
	}//deleteChat
	
	public int delete( MessageDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.delete("MessageMapper.delete", dto);
		return successCount;
	}//delete

	
	public int chat( MessageDTO dto) {
		int successCount = 0;
		System.out.println(dto);
		successCount = sqlSession.insert("MessageMapper.chat", dto);
		System.out.println(successCount);
		return successCount;
	}
	
	public List<MessageDTO> chatList( MessageDTO dto ) {
		List<MessageDTO> list = null;
		list = sqlSession.selectList("MessageMapper.chatList", dto);
		return list;
	}//list
	
	public int makeMemoRoom( MessageDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("MessageMapper.makeMemoRoom", dto);
		return successCount;
	}//makeMemoRoom

	public List<MessageDTO> searchList( SearchDTO dto ) {
		List<MessageDTO> list = null;
		System.out.println(dto);
		list = sqlSession.selectList("MessageMapper.selectList", dto);
		System.out.println(list);
		return list;
	}//searchList

	public int searchListCount( SearchDTO dto ) {
		int totalCount = 0;
		totalCount = sqlSession.selectOne("MessageMapper.searchListCount", dto);
		return totalCount;
	}//searchListCount

}//class
