package kr.co.ictedu.message;

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
@RequestMapping( value = "/message" )
public class MessageController {

   private final static Logger logger = LoggerFactory.getLogger(MessageController.class);

   @Autowired
   private MessageService service;

   
   @RequestMapping( value = "/delete", method = RequestMethod.POST )
   public void delete( MessageDTO dto, HttpSession session, PrintWriter out ) {
      int successCount = 0;
      successCount = service.delete( dto );
      out.print(successCount);
      out.close();
   }//delete

   
   @RequestMapping( value = "/chat", method = RequestMethod.POST )
   public void insert( MessageDTO dto, HttpSession session, PrintWriter out ) {
      int successCount = 0;
      successCount = service.chat( dto );
      out.print(successCount);
      out.close();
   }//insert
   
   
   
   @RequestMapping( value = "/chat_list", method = RequestMethod.GET )
       public String writeForm(MessageDTO dto, Model model) {
      logger.info(dto.getRoom());
      logger.info(dto.getSend_mno());
      logger.info(dto.getRecv_mno());
      model.addAttribute("dto_from_list", dto);
 
      List<MessageDTO> list = null;
      list = service.chatList( dto );
      model.addAttribute("chat_list", list);

      return "message/chat_list_in_write_form";//jsp file name
   }//사용자 정보 가져오기
   
   @RequestMapping( value = "/write_form", method = RequestMethod.POST )
       public String writeForm(MessageDTO dto, Model model ,HttpSession session) {
      logger.info(dto.getRoom());
      logger.info(dto.getSend_mno());
      logger.info(dto.getSend_mid());
      logger.info(dto.getRecv_mno());
      logger.info(dto.getRecv_mid());

      String loginMno = ( (MemberDTO) session.getAttribute("login_info") ).getMno();

      if(loginMno.equals(dto.getSend_mno()) == false) {
         String tmp = dto.getSend_mno();
         dto.setSend_mno( dto.getRecv_mno() );
         dto.setRecv_mno( tmp );
      }

      model.addAttribute("dto_from_list", dto);
 
      List<MessageDTO> list = null;
      list = service.chatList( dto );
      model.addAttribute("chat_list", list);

      return "message/write_form";//jsp file name
   }//사용자 정보 가져오기
   
   
   
   

   @RequestMapping( value = "/make_memo_room", method = RequestMethod.POST )
   public void makeMemoRoom( MessageDTO dto, HttpSession session, PrintWriter out ) {
      dto.setSend_mno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

      int successCount = 0;
      successCount = service.makeMemoRoom( dto );
      out.print(successCount);
      out.close();
   }//makeMemoRoom
   
   
   

   @RequestMapping( value = "/list", method = RequestMethod.GET )
   public String list( Model model, HttpSession session, String userWantPage, SearchDTO dto ) {
      dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

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

      List<MessageDTO> list = null;
      list = service.searchList( dto );
      model.addAttribute("list", list);
      model.addAttribute("search_dto", dto);
      return "/message/list";//jsp file name
      
   }//list

}//class
   

/*
CREATE TABLE `message` (
  `room_no` int NOT NULL AUTO_INCREMENT,
  `send_mno` int NOT NULL,
  `recv_mno` int NOT NULL,
  `send_time` datetime NOT NULL,
  `content` varchar(1500) NOT NULL,
  `read_chk` int NOT NULL,
  PRIMARY KEY (`room_no`)
);
*/