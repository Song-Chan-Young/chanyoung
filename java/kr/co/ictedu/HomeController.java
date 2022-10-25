package kr.co.ictedu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/home") 
	public String address() {
		System.out.println("카카오 API 테스트");
		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//sending mail
				String setfrom = "@.com";//보내는 사람 이메일
				String tomail  = "@.com";//받는 사람 이메일
				String title   = "테스트 메일 입니다.";//제목
				String content = "this email is test email.";//내용

				try {
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
					
					messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
					messageHelper.setTo(tomail);     // 받는사람 이메일
					messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
					messageHelper.setText(content);  // 메일 내용
					
					mailSender.send(message);
				} catch(Exception e){
					System.out.println(e);
				}//try

		return "home";//jsp file name
	}//home
	
	
	@RequestMapping( value = "/index/mypage", method = RequestMethod.GET )
	public String loginForm() {
		return "/index/mypage";//jsp file name
	}//loginForm
	
}
