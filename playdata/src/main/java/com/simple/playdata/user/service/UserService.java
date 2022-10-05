package com.simple.playdata.user.service;

import com.simple.playdata.command.UsersVO;

public interface UserService {

	public int idCheck(UsersVO vo);
	public int join(UsersVO vo);
	public UsersVO login(UsersVO vo);
}
