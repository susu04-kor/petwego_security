package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.vo.LoginLogVo;
import com.example.demo.vo.MemberInfoVo;
import com.example.demo.vo.MemberInfoVo2;

public interface SecurityService extends UserDetailsService {
	
	
	
	//시큐리티 사용자 인증
	UserDetails loadUserByUsername(String user_id);
	
	MemberInfoVo getSelectMemberInfo(String user_id) throws Exception;
	//회원가입
	public int setInsertMemberInfo(MemberInfoVo memberInfo) throws Exception;
	//로그 기록 ----------넣는 게 맞나? AuthSuccessHandler, AuthFailureHandler에 쓰임
	public int setInsertLoginLog(LoginLogVo loginLog) throws Exception;
	//중복 아이디 체크
	int idCheck(String user_id) throws Exception;
	
	
	
//	 Collection<GrantedAuthority> getAuthorities(String username);
//     public User readUser(String username);
//     public void createUser(User user);
//     public void deleteUser(String username);
//     public PasswordEncoder passwordEncoder();

	
	
}

//회원가입 - 
//회원 권한을 디폴트로 0 주고
//관리자는 cmd창에 직접 입력하기