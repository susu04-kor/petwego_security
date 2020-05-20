//package com.example.demo.security.handlers;
//
//import java.io.IOException;
//
//import javax.inject.Inject;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.service.SecurityService;
//import com.example.demo.util.CommonUtil;
//import com.example.demo.vo.LoginLogVo;
//
////로그인 성공시 SimpleUrlAuthenticationSuccessHandler를 상속받아 성공 로직 구현 후 로그인 로그를 남김
////loadUserByUsername에서 리턴받은 memberInfoVo가 null일 때 UsernameNotFoundExceprion을 통해
////AuthenticationFailureHandler가 실행되고
////사용자 정보가 있으면 인증 후 객체 리턴
////리턴 후 SimpleUrlAuthenticationSuccessHandler이 실행됨
//
//@Component
//public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(AuthSuccessHandler.class);
//	
//	@Autowired //혹은 @Inject
//	SecurityService securityService;
//
////	public AuthSuccessHandler(String string) {
////		// TODO Auto-generated constructor stub
////	}
//
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {
//		
//		String ip = CommonUtil.getClientIP(request);
//		System.out.println(ip);
//		LOGGER.info("============로그인 성공============");
//		System.out.println("AuthSuccessHandler");
//		LoginLogVo loginLog = new LoginLogVo();
//		String id = "";
//		
//		
//		try {
//			id = authentication.getName().toString();
//			loginLog.setLoginIp(ip);
//			loginLog.setUser_id(id);
//			loginLog.setStatus("SUCCESS");
//			securityService.setInsertLoginLog(loginLog);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		super.setDefaultTargetUrl("/MainPage");	
//		super.onAuthenticationSuccess(request, response, authentication);
//		
//		
//		
//	}
//	
//	// 실행 후 로그를 확인하면, 로그인이 성공한 시점에 IP 정보를 받아옴 
//	
//}
