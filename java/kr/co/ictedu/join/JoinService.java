package kr.co.ictedu.join;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ictedu.util.dto.MemberDTO;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class JoinService {

	@Autowired
	private JoinDAO dao;

	public int join( MemberDTO dto ) {
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

		successCount = dao.join( dto );
		return successCount;
	}//join

	public int idCheck( String mid ) {
		int isYN = 0;
		isYN = dao.idCheck( mid );
		return isYN;
	}//idCheck
	
	public void certifiedPhoneNumber(String userPhoneNumber, int randomNumber) {
		String api_key = "NCSWOLH7XRDJ32HR";
	    String api_secret = "PSNDOFIYE6MVUDBUVSD6RKKS94AVWPAO";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", "010-9384-6429");    // 수신전화번호
	    params.put("from", "010-9384-6429");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
	    params.put("type", "SMS");
	    params.put("text", "[TEST] 인증번호는" + "["+randomNumber+"]" + "입니다."); // 문자 내용 입력
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	        JSONObject obj = (JSONObject) coolsms.send(params);
	        System.out.println(obj.toString());
	      } catch (CoolsmsException e) {
	        System.out.println(e.getMessage());
	        System.out.println(e.getCode());
	      }
	    
	} //PhoneCheck

}//class
