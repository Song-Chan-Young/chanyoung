package kr.co.ictedu.mypage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ictedu.util.dto.MemberDTO;
 
@Service
public class MypageService {

	@Autowired
	private MypageDAO dao;

	public int update( MemberDTO dto ) {
		int successCount = 0;

		if( dto.getTel1() != null && !dto.getTel1().equals("")
			&& dto.getTel2() != null && !dto.getTel2().equals("")
			&& dto.getTel3() != null && !dto.getTel3().equals("") ) {
			dto.setTel( dto.getTel1() + "-" + dto.getTel2() + "-" + dto.getTel3() );
		}

		if( dto.getEmail1() != null && !dto.getEmail1().equals("")
			&& dto.getEmail2() != null && !dto.getEmail2().equals("") ) {
			dto.setEmail( dto.getEmail1() + "@" + dto.getEmail2() );
		}

		successCount = dao.update( dto );
		return successCount;
	}//update
	
	
	
	
	public MemberDTO detail( String mno ) {
		dao.detail( mno );

		MemberDTO dto = null;
		dto = dao.detail( mno );
		return dto;
	}//detail

}//class






