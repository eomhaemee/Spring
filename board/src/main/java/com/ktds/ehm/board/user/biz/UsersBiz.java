package com.ktds.ehm.board.user.biz;

import java.util.List;

import com.ktds.ehm.board.user.vo.UsersVO;

public interface UsersBiz {

	public List<UsersVO> getAllUsers();
	public UsersVO getOneUsers(UsersVO usersVO);

	public boolean signUpUser(UsersVO usersVO);
	
}
