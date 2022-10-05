package com.simple.playdata.user.service;

import org.apache.ibatis.annotations.Mapper;

import com.simple.playdata.command.UsersVO;

@Mapper
public interface UserMapper {
	
	public int idCheck(UsersVO vo);
	public int join(UsersVO vo);
	public UsersVO login(UsersVO vo);
}
