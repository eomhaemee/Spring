package com.ktds.ehm.board.user.dao;

import java.util.List;

import com.ktds.ehm.board.user.vo.UsersVO;

public interface UsersDao {
	public List<UsersVO> selectAllUsers();
	public UsersVO selectOneUsers(UsersVO usersVO);
	public int insertUsers(UsersVO usersVO);
	public int updateUsers(UsersVO usersVO);
	public int deleteUsers(String userId);

	
}
