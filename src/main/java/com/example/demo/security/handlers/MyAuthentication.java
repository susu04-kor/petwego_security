//package com.example.demo.security.handlers;
//
//import java.util.List;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import com.example.demo.vo.MemberInfoVo;
//import com.example.demo.vo.MemberInfoVo2;
//
//import lombok.Data;
//
////현재 로그인한 사용자 객체 저장 DTO (Data Transfer Object) // DTO 뭔지!! 학습 더 필요!
//@Data
//public class MyAuthentication extends UsernamePasswordAuthenticationToken {
//
//	private static final long serialVersionUID = 1L;
//	
//	
//	MemberInfoVo memberInfo;
//
//	public MyAuthentication(String id, String password, List<GrantedAuthority> grantedAuthorityList, MemberInfoVo memberInfo) {
//		super(id, password, grantedAuthorityList);
//		this.memberInfo = memberInfo;
//	}
//
//	
//
//	
//	
//	
//	
//	
//}
