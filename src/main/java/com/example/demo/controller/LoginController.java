package com.example.demo.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.SecurityService;
import com.example.demo.vo.MemberInfoVo;

@Controller
public class LoginController {
   
   //Logger 기록 남길 때 사용
   
   @Autowired
   SecurityService securityService;
   
   @Autowired
   PasswordEncoder passwordEncoder;
   
   private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
   //로그인
   @RequestMapping(value="/login/login")
   public ModelAndView login(HttpServletRequest request, @RequestParam(value="msg", required=false) String msg) throws Exception {
      ModelAndView mav = new ModelAndView();
      mav.addObject("msg", msg);
      mav.setViewName("/login/login");
      return mav;
   }
   
   /*
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login() {
	   return "/login/login";
   }
   */
   
   // 로그인 post
	@RequestMapping(value = "/login/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, String user_id, MemberInfoVo member, HttpSession session, RedirectAttributes rttr) throws Exception{
		LOGGER.info("post login");
	
//		String referer = request.getHeader("Referer"); 
//		request.getSession().setAttribute("prevPage", referer);
		
		String before_address = request.getHeader("referer");
		
	    session.getAttribute("member");
		MemberInfoVo login = securityService.getSelectMemberInfo(user_id);
		boolean pwdMatch = passwordEncoder.matches(member.getPwd(), login.getPwd());

		String url = null;
		if(login != null && pwdMatch == true) {
			session.setAttribute("member", login);
			url = before_address;
			System.out.println("로그인컨트롤러 - 이전페이지로!");
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			url = "/login/login";
			System.out.println("로그인컨트롤러 - 로그인페이지로!");
		}
	
		//return "redirect:/MainPage";
		return "url";
	}
   
   
   @RequestMapping("/login/logout")
   public String logout(HttpServletRequest request) {
      return "/login/logout";
   }
 
   
   @RequestMapping(value = "/login/logout", method = RequestMethod.POST) 
   public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception { 
      Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
      if (auth != null){ 
         new SecurityContextLogoutHandler()
            .logout(request, response, auth); 
      } 
      return "redirect:/MainPage"; 
   }

   /*
   //로그인 에러페이지 이동
   @GetMapping("/login-error")
   public String error() {
      return "login/error";
   }
   */
  
   
   //아이디 중복체크
   @RequestMapping(value="/join/idCheck", method=RequestMethod.GET, produces="application/text; charset=utf8")
   @ResponseBody
   public String idCheck(HttpServletRequest request) throws Exception{
      LOGGER.info("post idCheck");
      int result = 0;
      String user_id = request.getParameter("user_id");
      int idUseYn = securityService.idCheck(user_id);
      
      if(idUseYn > 0) {   //아이디 있을 경우
         result = -1;
      }else {
         result = 0;
      }
      return Integer.toString(result);
	
   }
   
   //닉네임 중복체크
   @RequestMapping(value="/join/nickCheck", method=RequestMethod.GET, produces="application/text; charset=utf8")
   @ResponseBody
   public String nickCheck(HttpServletRequest request) throws Exception{
      LOGGER.info("post nickCheck");
      int result = 0;
      String nick_name = request.getParameter("nick_name");
      int nickUseYn = securityService.nickCheck(nick_name);
      
      if(nickUseYn > 0) {   //아이디 있을 경우
         result = -1;
      }else {
         result = 0;
      }
      return Integer.toString(result);
	
   }
   
   
   //회원가입 페이지 이동
   @RequestMapping("/join/join")
   public String join(HttpServletRequest request) {
      return "login/join";
   }
   
   //회원가입
   @RequestMapping("/join/insert")
   public String setInertMemberInfo(HttpServletResponse res, HttpServletRequest req) throws Exception{
      
         
      
      //memberInfo.setPwd(pass);
      
      //DB에는 Date타입, vo에는 String 타입, 가져올 땐 다시 TO_CHAR
      
        String user_id = req.getParameter("user_id");
        String pwd = req.getParameter("pwd");
     
        String pass = passwordEncoder.encode(pwd);  
        
        String tel = req.getParameter("tel");
        String birth = req.getParameter("birth");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String gender = req.getParameter("gender");
        String fname = req.getParameter("fname");
        String intro = req.getParameter("intro");
        String info_create_date = req.getParameter("info_create_date");
        String info_update_date = req.getParameter("info_update_date");
        String nick_name = req.getParameter("nick_name");
        String user_role = req.getParameter("user_role");
        String status = req.getParameter("status");
        String email = req.getParameter("email");
      
      MemberInfoVo member = new MemberInfoVo(user_id, pass, tel, birth, name, address, gender,
    		  fname, intro, info_create_date, info_update_date, nick_name, user_role, status, email);
      
      int re = securityService.setInsertMemberInfo(member);
      
      System.out.println(member);
      if( re > 0 ) {
         return "/login/login";
      }else {
         return "/login/join";
      }
   }
   
   
  
   
   
   
   
}