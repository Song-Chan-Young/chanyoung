package kr.co.ictedu.mypage;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ictedu.util.dto.MemberDTO;

@Repository
public class MypageDAO {

	@Autowired
	private SqlSession sqlSession;

	public int update( MemberDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.update("MypageMapper.update", dto);
		return successCount;
	}//update
	
	
	public MemberDTO detail( String mno ) {
		MemberDTO dto = null;
		dto = sqlSession.selectOne("MypageMapper.detail", mno);
		return dto;
	}//detail
	
	

}//class








