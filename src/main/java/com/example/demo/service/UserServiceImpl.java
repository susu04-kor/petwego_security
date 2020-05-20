package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginMapperDao;
import com.example.demo.vo.LoginLogVo;
import com.example.demo.vo.MemberInfoVo;
import com.example.demo.vo.MemberInfoVo2;


@Service
public class UserServiceImpl implements SecurityService {

	@Autowired
	LoginMapperDao loginMapperDao;
	
	
	//user 정보를 읽을 때 사용
	//user를 읽어왔으면 권한을 부여
	//회원가입할 때 권한은 string으로 저장해야 합니다
	//권한은 MyBatis를 통해 String을 가져왔으므로 
	//GrantedAuthority 인터페이스에 맞게 SimpleGrantedAuthority로 변환해서 
	//MemberInfoVo에 있는 authorities에 setter를 합니다
	//그러면 로그인한 유저에게 권한이 부여됩니다
	
	
	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException{
		MemberInfoVo memberInfo = loginMapperDao.getSelectMemberInfo(user_id);
		System.out.println(user_id+"........loadUserByUsername");
		System.out.println("memberInfoVo===>"+memberInfo);
	
		if(memberInfo==null) {	//throw = 예외 강제 발생 메소드
			throw new UsernameNotFoundException(user_id);
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(memberInfo.getUser_role()));
		
		MemberInfoVo member = new MemberInfoVo(memberInfo.getUser_id(), memberInfo.getPwd(), 
				memberInfo.getTel(), memberInfo.getBirth(), memberInfo.getName(), 
				memberInfo.getAddress(), memberInfo.getGender(), memberInfo.getFname(), 
				memberInfo.getIntro(), memberInfo.getInfo_create_date(), 
				memberInfo.getInfo_create_date(), memberInfo.getNick_name(), 
				memberInfo.getUser_role(), memberInfo.getStatus(), 
				memberInfo.getEmail(), authorities);
	
		return member;
		
		/*		
		if(memberInfo==null) {	//throw = 예외 강제 발생 메소드
			throw new UsernameNotFoundException(user_id);
		}
		
		//객체 생성해서 반환하기 
		return User.builder()
				.username(user_id)		//username은 이렇게 할게요
				.password(memberInfo.getPwd())	//비밀번호는 이렇게 받을게요
				.roles(memberInfo.getUser_role())	//권한은 이렇게 할게요
				.build();				//생성합니다
		 */	
	}

	
	@Override
	public MemberInfoVo getSelectMemberInfo(String user_id) throws Exception {
		return loginMapperDao.getSelectMemberInfo(user_id);
	}

	@Override
	public int setInsertMemberInfo(MemberInfoVo memberInfo) throws Exception {
		return loginMapperDao.setInsertMemberInfo(memberInfo);
	}

	//이 메소드는 꼭 필요한지 확인작업이 필요함
	@Override
	public int setInsertLoginLog(LoginLogVo loginLog) throws Exception {
		// TODO Auto-generated method stub
		return loginMapperDao.setInsertLoginLog(loginLog);
	}
	
	@Override
	public int idCheck(String user_id) throws Exception {
		return loginMapperDao.idCheck(user_id);
	}
	
	
	
	

}
