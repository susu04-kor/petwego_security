package com.example.demo.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


//로그인 성공하면 타게 되는 클래스 
@Component
public class LoginSuccessHandlerAgain extends SavedRequestAwareAuthenticationSuccessHandler {
	
	public LoginSuccessHandlerAgain(String defaultTargetUrl) {
		setDefaultTargetUrl(defaultTargetUrl); 
	} 
	
	
	
	public LoginSuccessHandlerAgain() {
		// TODO Auto-generated constructor stub
	}



	/** * 인증에 성공할 경우 아래 매서드로 이동. / 로그인 후 이전 페이지로 이동하게 하기 위한 메소드 */ 
	@Override public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication) throws ServletException, IOException { 
		HttpSession session = request.getSession(); 
		if (session != null) { 
			String redirectUrl = (String) session.getAttribute("prevPage"); 
			if (redirectUrl != null) { 
				session.removeAttribute("prevPage"); 
				getRedirectStrategy().sendRedirect(request, response, redirectUrl); 
			} else { 
					super.onAuthenticationSuccess(request, response, authentication); 
			} 
		} else { 
			super.onAuthenticationSuccess(request, response, authentication); 
		} 
	}

	//출처: https://lemontia.tistory.com/601 [side impact]
}
