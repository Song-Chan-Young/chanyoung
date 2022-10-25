package kr.co.ictedu.contact.faq;

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

import kr.co.ictedu.util.dto.MemberDTO;
import kr.co.ictedu.util.dto.SearchDTO;

@Controller
@RequestMapping( value = "/contact/faq" )
public class ContactFaqController {

	private final static Logger logger = LoggerFactory.getLogger(ContactFaqController.class);

	@Autowired
	private ContactFaqService service;

	@RequestMapping( value = "/update", method = RequestMethod.POST )
	public void update( ContactFaqDTO dto, HttpSession session, PrintWriter out ) {
		MemberDTO mDto = (MemberDTO) session.getAttribute("login_info");
		dto.setMno( mDto.getMno() );

		int successCount = 0;
		successCount = service.update( dto );
		out.print(successCount);
		out.close();
	}//update

	@RequestMapping( value = "/update_form", method = RequestMethod.GET )
	public String updateForm( String board_no, Model model ) {
		ContactFaqDTO dto = null;
		dto = service.detail(board_no);
		model.addAttribute("detail_dto", dto);
		return "/contact/faq/update_form";//jsp file name
	}//updateForm

	@RequestMapping( value = "/delete", method = RequestMethod.GET )
	public void delete( ContactFaqDTO dto, HttpSession session, PrintWriter out ) {
		MemberDTO mDto = (MemberDTO) session.getAttribute("login_info");
		dto.setMno( mDto.getMno() );

		int successCount = 0;
		successCount = service.delete( dto );
		out.print(successCount);
		out.close();
	}//delete

	@RequestMapping( value = "/detail", method = RequestMethod.GET )
	public String detail( String board_no, Model model ) {
		ContactFaqDTO dto = null;
		dto = service.detail( board_no );
		model.addAttribute("detail_dto", dto);
		return "/contact/faq/detail";//jsp file name
	}//detail

	@RequestMapping( value = "/write", method = RequestMethod.POST )
	public void write( ContactFaqDTO dto, HttpSession session, PrintWriter out ) {
		MemberDTO mDto = (MemberDTO) session.getAttribute("login_info");
		dto.setMno( mDto.getMno() );

		int successCount = 0;
		successCount = service.write( dto );
		out.print(successCount);
		out.close();
	}//write

	@RequestMapping( value = "/write_form", method = RequestMethod.GET )
	public String writeForm() {
		return "/contact/faq/write_form";//jsp file name
	}//writeForm

	@RequestMapping( value = "/list", method = RequestMethod.GET )
	public String list( Model model, String userWantPage, SearchDTO dto ) {
		if( userWantPage == null || userWantPage.equals("") ) userWantPage = "1";
		int totalCount = 0, startPageNum = 1, endPageNum = 10, lastPageNum = 1;
		totalCount = service.searchListCount( dto );

		if(totalCount > 10) {//201 -> (201 /10) + (201 % 10 > 0 ? 1 : 0) -> 20 + 1
			lastPageNum = (totalCount / 10) + (totalCount % 10 > 0 ? 1 : 0);
		}//if

		if(userWantPage.length() >= 2) { //userWantPage가 12인 경우 startPageNum는 11, endPageNum는 20.
			String frontNum = userWantPage.substring(0, userWantPage.length() - 1);//12 -> 1
			startPageNum = Integer.parseInt(frontNum) * 10 + 1;// 1 * 10 + 1 -> 11
			endPageNum = ( Integer.parseInt(frontNum) + 1 ) * 10;// (1 + 1) * 10 -> 20
			//userWantPage가 10인 경우, startPageNum는 11, endPageNum는 20.
			String backNum = userWantPage.substring(userWantPage.length() - 1, userWantPage.length());
			if(backNum.equals("0")) {
				startPageNum = startPageNum - 10;// 11 - 10 -> 1
				endPageNum = endPageNum - 10;// 20 - 10 -> 10
			}//if
		}//if

		//endPageNum이 20이고, lastPageNum이 17이라면, endPageNum을 17로 수정해라
		if(endPageNum > lastPageNum) endPageNum = lastPageNum;

		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("userWantPage", userWantPage);

		dto.setLimitNum( ( Integer.parseInt(userWantPage) - 1 ) * 10  );

		List<ContactFaqDTO> list = null;
		list = service.searchList( dto );
		model.addAttribute("list", list);
		model.addAttribute("search_dto", dto);
		return "/contact/faq/list";//jsp file name
		
	}//list

}//class

/*
CREATE TABLE `contactfaq` (
`board_no` int NOT NULL AUTO_INCREMENT,
`title` varchar(150) NOT NULL,
`writer` varchar(60) NOT NULL,
`contents` varchar(1500) NOT NULL,
`write_date` datetime NOT NULL,
`view_cnt` int DEFAULT '0',
 PRIMARY KEY (`board_no`)
);
		
*/





