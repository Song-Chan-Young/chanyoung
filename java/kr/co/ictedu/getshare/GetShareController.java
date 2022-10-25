package kr.co.ictedu.getshare;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import kr.co.ictedu.util.dto.MemberDTO;
import kr.co.ictedu.util.dto.SearchDTO;

@Controller
@RequestMapping( value = "/getshare" )
public class GetShareController {
	
	private static final Logger logger = LoggerFactory.getLogger(GetShareController.class);

	@Autowired
	private GetShareService service;

	@RequestMapping( value = "/update", method = RequestMethod.POST )
	public void update( GetShareDTO dto, HttpSession session, PrintWriter out ) throws IOException {

		Date today = new Date();
		DateFormat nalja = new SimpleDateFormat("YYYYMMDD");
		DateFormat sigan = new SimpleDateFormat("HHmmss");
		String todayNalja = nalja.format(today);
		String todaySigan = sigan.format(today);

		String mid = ( (MemberDTO) session.getAttribute("login_info") ).getMid();
		File newFolder = new File("C:/upload/product/" + mid + "/");
		if( newFolder.exists() == false ) newFolder.mkdirs();

		InputStream is = null;
		FileOutputStream fos = null;

		MultipartFile thumbnail = dto.getThumbnail();
		if(thumbnail != null && !thumbnail.getOriginalFilename().equals("")) {
			is = thumbnail.getInputStream();
			fos = new FileOutputStream( "C:/upload/product/" + mid + "/" + todayNalja + "_"
														+ todaySigan + "_" + thumbnail.getOriginalFilename() );
			FileCopyUtils.copy(is, fos);
			is.close();
			fos.close();
			dto.setThumbnail_name(todayNalja + "_" + todaySigan + "_" + thumbnail.getOriginalFilename());
			dto.setThumbnail_path("/upload/product/" + mid + "/" + todayNalja + "_"
									+ todaySigan + "_" + thumbnail.getOriginalFilename());
		}

		MultipartFile prdt_img = dto.getPrdt_img();
		if(prdt_img != null && !prdt_img.getOriginalFilename().equals("")) {
			is = prdt_img.getInputStream();
			fos = new FileOutputStream( "C:/upload/product/" + mid + "/" + todayNalja + "_"
										+ todaySigan + "_" + prdt_img.getOriginalFilename() );
			FileCopyUtils.copy(is, fos);
			is.close();
			fos.close();
			dto.setPrdt_img_name(todayNalja + "_" + todaySigan + "_" + prdt_img.getOriginalFilename());
			dto.setPrdt_img_path("/upload/product/" + mid + "/" + todayNalja + "_"
									+ todaySigan + "_" + prdt_img.getOriginalFilename());
		}

		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		int successCount = 0;
		successCount = service.update( dto );
		out.print(successCount);
		out.close();
	}//update

	@RequestMapping( value = "/file/delete", method = RequestMethod.GET )
	public void fileDelete( String id, String path, GetShareDTO dto, HttpSession session, PrintWriter out ) {
		File file = new File("C:" + path);
		file.delete();

		if(id.equals("thumbnail_btn")) {
			dto.setThumbnail_name(path.substring(path.lastIndexOf("/") + 1) );
			dto.setThumbnail_path(path);
		} else if(id.equals("prdt_img_btn")) {
			dto.setPrdt_img_name( path.substring(path.lastIndexOf("/") + 1) );
			dto.setPrdt_img_path(path);
		}
		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		int successCount = 0;
		successCount = service.fileDelete( dto );
		out.print(successCount);
		out.close();
	}//fileDelete

	@RequestMapping( value = "/uform", method = RequestMethod.GET )
	public String updateForm( String prdt_no, Model model ) {
		GetShareDTO dto = null;
		dto = service.detail( prdt_no );
		model.addAttribute("detail_dto", dto);
		return "/getshare/uform";//jsp file name
	}//updateForm

	@RequestMapping( value = "/delete", method = RequestMethod.GET )
	public void delete( GetShareDTO dto, HttpSession session, PrintWriter out ) {

		if(!dto.getThumbnail_path().equals("")) {
			File file = new File("C:" + dto.getThumbnail_path());
			file.delete();
		}
		if(!dto.getPrdt_img_path().equals("")) {
			File file = new File("C:" + dto.getPrdt_img_path());
			file.delete();
		}
		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		int successCount = 0;
		successCount = service.delete( dto );
		out.print(successCount);
		out.close();
	}//delete

	@RequestMapping( value = "/detail", method = RequestMethod.GET )
	public String detail( String prdt_no, Model model ) {
		GetShareDTO dto = null;
		dto = service.detail( prdt_no );
		model.addAttribute("detail_dto", dto);
		return "/getshare/detail";//jsp file name
	}//detail

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

		List<GetShareDTO> list = null;
		list = service.searchList( dto );
		model.addAttribute("list", list);
		model.addAttribute("search_dto", dto);
		return "/getshare/list";//jsp file name
	}//list

	@RequestMapping( value = "/insert", method = RequestMethod.POST )
	public void insert( GetShareDTO dto, HttpSession session, PrintWriter out ) throws IOException {

		Date today = new Date();
		DateFormat nalja = new SimpleDateFormat("YYYYMMDD");
		DateFormat sigan = new SimpleDateFormat("HHmmss");
		String todayNalja = nalja.format(today);
		String todaySigan = sigan.format(today);

		String mid = ( (MemberDTO) session.getAttribute("login_info") ).getMid();
		File newFolder = new File("C:/upload/product/" + mid + "/");
		if( newFolder.exists() == false ) newFolder.mkdirs();

		MultipartFile thumbnail = dto.getThumbnail();
		InputStream is = thumbnail.getInputStream();
		FileOutputStream fos = new FileOutputStream( "C:/upload/product/" + mid + "/" + todayNalja + "_"
													+ todaySigan + "_" + thumbnail.getOriginalFilename() );
		FileCopyUtils.copy(is, fos);
		is.close();
		fos.close();
		dto.setThumbnail_name(todayNalja + "_" + todaySigan + "_" + thumbnail.getOriginalFilename());
		dto.setThumbnail_path("/upload/product/" + mid + "/" + todayNalja + "_"
								+ todaySigan + "_" + thumbnail.getOriginalFilename());

		MultipartFile prdt_img = dto.getPrdt_img();
		if(prdt_img != null && !prdt_img.getOriginalFilename().equals("")) {
			is = prdt_img.getInputStream();
			fos = new FileOutputStream( "C:/upload/product/" + mid + "/" + todayNalja + "_"
										+ todaySigan + "_" + prdt_img.getOriginalFilename() );
			FileCopyUtils.copy(is, fos);
			is.close();
			fos.close();
			dto.setPrdt_img_name(todayNalja + "_" + todaySigan + "_" + prdt_img.getOriginalFilename());
			dto.setPrdt_img_path("/upload/product/" + mid + "/" + todayNalja + "_"
									+ todaySigan + "_" + prdt_img.getOriginalFilename());
		}
		
		dto.setMno( ( (MemberDTO) session.getAttribute("login_info") ).getMno() );

		int successCount = 0;
		successCount = service.insert(dto);
		out.print(successCount);
		out.close();
	}//insert

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form( GetShareDTO dto, Model model ) {
		model.addAttribute("dto", dto);
		return "getshare/form";//jsp file name
	}//form
	
}//class

/*
create table getshare(
prdt_no int primary key auto_increment
, page_list varchar(100) default null
, page_gubun varchar(60) default null
, prdt_name varchar(60) not null
, mno int not null
, qty int not null
, price int not null
, discount double not null
, description varchar(1500)
, view_cnt int default 0
, reg_date datetime
, del_yn int default 0
, del_date datetime
, thumbnail_name varchar(100) not null
, thumbnail_path varchar(100) not null
, prdt_img_name varchar(100)
, prdt_img_path varchar(100)
);
*/
