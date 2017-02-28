package com.ktds.ehm.board.user.biz;

import java.util.List;

import com.ktds.ehm.board.user.dao.UsersDao;
import com.ktds.ehm.board.user.dao.UsersDaoImpl;
import com.ktds.ehm.board.user.vo.UsersVO;

public class UsersBizImpl implements UsersBiz {

	private UsersDao userDao;

	public UsersBizImpl() {
		userDao = new UsersDaoImpl();
	}

	@Override
	public boolean signUpUser(UsersVO usersVO) {

		return userDao.insertUsers(usersVO) > 0;
	}

	@Override
	public List<UsersVO> getAllUsers() {
		
		return userDao.selectAllUsers();
	}

	@Override
	public UsersVO getOneUsers(UsersVO usersVO) {
		// TODO Auto-generated method stub
		return userDao.selectOneUsers(usersVO);
	}

}
