package kr.co.ictedu.credit.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

	@Autowired
	private CreditCardDAO dao;

	public int delete( CreditCardDTO dto ) {
		int successCount = 0;
		successCount = dao.delete( dto );
		return successCount;
	}//delete

	public int insert( CreditCardDTO dto ) {
		int successCount = 0;
		successCount = dao.insert( dto );
		return successCount;
	}//write

	public List<CreditCardDTO> list( String mno ) {
		List<CreditCardDTO> list = null;
		list = dao.list( mno );
		return list;
	}//list

}//class
