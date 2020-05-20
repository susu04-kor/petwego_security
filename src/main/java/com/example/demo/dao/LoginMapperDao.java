package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.LoginLogVo;
import com.example.demo.vo.MemberInfoVo;
import com.example.demo.vo.MemberInfoVo2;

@Mapper
public interface LoginMapperDao {
	
	//회원정보 조회
	MemberInfoVo getSelectMemberInfo(String user_id);
	//회원가입
	public int setInsertMemberInfo(MemberInfoVo memberInfo);
	//로그인 로그
	public int setInsertLoginLog(LoginLogVo loginlog);
	
	public int idCheck(String user_id);
	
	
}
