package kr.co.ictedu.credit.card;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@Controller
@RequestMapping( value = "/credit/card" )
public class CreditCardController {

	private final static Logger logger = LoggerFactory.getLogger(CreditCardController.class);

	@Autowired
	private CreditCardService service;

	@RequestMapping( value = "/delete", method = RequestMethod.GET )
	public void delete( CreditCardDTO dto, HttpSession session, PrintWriter out ) {
		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		int successCount = 0;
		successCount = service.delete( dto );
		out.print(successCount);
		out.close();
	}//delete

	@RequestMapping( value = "/insert", method = RequestMethod.POST )
	public void insert( CreditCardDTO dto, HttpSession session, PrintWriter out ) {
		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		int successCount = 0;
		successCount = service.insert( dto );
		out.print(successCount);
		out.close();
	}//insert

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form( Model model, HttpSession session ) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("YYYY");
		String yearString = dateFormat.format(date);
		model.addAttribute("yearString", yearString);

		List<CreditCardDTO> list = null;
		list = service.list( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );
		model.addAttribute("list", list);
		return "credit/card/form";//jsp file name
	}//form

}//class

/*
drop table credit_card;

create table credit_card (
  card_no int not null auto_increment,
  card_name varchar(60) not null,
  mno int not null,
  card_number varchar(20) not null,
  expiry_date_month varchar(2) not null,
  expiry_date_year varchar(4) not null,
  cvc_code varchar(3) not null,
  pwd varchar(2) not null,
  used_date datetime not null,
  reg_date datetime not null,
  del_yn int default '0',
  del_date datetime default null,
  primary key (card_no)
);
*/
