package kr.co.ictedu.mypage;



import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ictedu.credit.card.CreditCardDTO;
import kr.co.ictedu.credit.card.CreditCardService;
import kr.co.ictedu.util.dto.MemberDTO;

@Controller
@RequestMapping(value = "/mypage")
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);



	@Autowired
	private MypageService service;

	@Autowired
	private CreditCardService creditCardService;

	@RequestMapping(value = "/list_credit_card", method = RequestMethod.GET)
	public String listCreditCard( Model model, HttpSession session ) {

		List<CreditCardDTO> cardlist = null;
		cardlist = creditCardService.list( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );
		model.addAttribute("cardlist", cardlist);

		return "/mypage/list_credit_card";
	}//listCreditCard

	

	
	@RequestMapping( value = "/update", method = RequestMethod.POST )
	public void update( MemberDTO dto, HttpSession session, PrintWriter out ) {
		MemberDTO mDto = (MemberDTO) session.getAttribute("login_info");
		dto.setMno( mDto.getMno() );

		int successCount = 0;
		successCount = service.update( dto );
		out.print(successCount);
		out.close();
	}//update
	
	@RequestMapping( value = "/update_form", method = RequestMethod.GET )
	public String updateForm( String mno, Model model ) {
		MemberDTO dto = null;
		dto = service.detail(mno);
		model.addAttribute("detail_dto", dto);
		return "mypage/update_form";//jsp file name
	}//updateForm
	
	
	@RequestMapping( value = "/list", method = RequestMethod.GET )
	public String detail( String mno, Model model ) {
		MemberDTO dto = null;
		dto = service.detail( mno );
		model.addAttribute("detail_dto", dto);
		return "mypage/list";//jsp file name
	}//detail
	

}//class
