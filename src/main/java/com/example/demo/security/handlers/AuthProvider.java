//package com.example.demo.security.handlers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.security.service.SecurityService;
//import com.example.demo.vo.MemberInfoVo;
//import com.example.demo.vo.MemberInfoVo2;
//
//
////커스텀 로그인을 위한 인터페이스입니다.
////서비스의 인증 결과로 로그인을 할 수 있지만
////로그인 성공 및 실패 유무에 따라 수행하는 로직을 만들기 위해서 AuthenticationProvider 인터페이스를 구현합니다.
//
//@Component
//public class AuthProvider implements AuthenticationProvider {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);
//	
//	@Autowired
//	SecurityService securityService;
//	
//	@Autowired
//	PasswordEncoder passwordEncoder; //암호화작업1
//	//로그인 버튼을 누를 경우
//
//	
//	//첫번째 실행
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String id = authentication.getName();
//		String password = authentication.getCredentials().toString();
//		return authenticate(id, password);
//	}
//
//	//두번째 실행
//	private Authentication authenticate(String id, String password) throws AuthenticationException{
//		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
//		MemberInfoVo memberInfo = new MemberInfoVo();	//vo에 생성자가 없어서 이게 선언이 안됨 그래서 autowired 해줘봤음 - 실패
//		UserDetails user = securityService.loadUserByUsername(id);
//		
//		if(user==null) {
//			LOGGER.info("사용자 정보가 없습니다");
//		}else if(user != null && !passwordEncoder.matches(password, user.getPassword())) {	// getPwd() 아냐
//			LOGGER.info("비밀번호가 틀렸습니다");
//			throw new BadCredentialsException(id);
//		}
//		
//		grantedAuthorityList.add(new SimpleGrantedAuthority(memberInfo.getUser_role()));
//		
//		return new MyAuthentication(id,password,grantedAuthorityList,memberInfo);
//		
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		
//		return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	}
//
//}
