package com.ktds.ehm.board.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.ehm.board.user.vo.UsersVO;
import com.ktds.ehm.dao.support.JDBCDaoSupport;
import com.ktds.ehm.dao.support.QueryHandler;
import com.ktds.ehm.dao.support.annotation.BindData;

public class UsersDaoImpl extends JDBCDaoSupport  implements UsersDao{

	@Override
	public List<UsersVO> selectAllUsers() {
		return selectList(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append("SELECT	USR_ID   ");
				query.append("        	,USR_NM   ");
				query.append("        	,USR_PWD ");
				query.append("        	,JOIN_DT ");
				query.append("FROM	USRS       ");
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				UsersVO usersVO = new UsersVO();
				BindData.bindData(rs, usersVO);
				return usersVO;
			}
		});
		
	}

	@Override
	public UsersVO selectOneUsers(UsersVO usersVO) {
		return (UsersVO) selectOne(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	USR_ID   ");
				query.append("        	,USR_NM   ");
				query.append("        	,USR_PWD ");
				query.append("        	,JOIN_DT ");
				query.append(" FROM	USRS       ");
				query.append(" WHERE USR_ID = ?   ");
				query.append(" AND 	USR_PWD = ?   ");
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, usersVO.getUserId());
				stmt.setString(2, usersVO.getUserPassword());
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				UsersVO usersVO = new UsersVO();
				BindData.bindData(rs, usersVO);
				return usersVO;
			}
		});
		
	}

	@Override
	public int insertUsers(UsersVO usersVO) {
		return update(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer();
				 query.append( "INSERT INTO USRS (");
	                query.append( "             USR_ID   ");
					query.append("        		,USR_NM   ");
					query.append("        		,USR_PWD ");
					query.append("        		,JOIN_DT ");
	                query.append( "                   ) ");
	                query.append( "VALUES             (");
	                query.append( "                    ? ");
	                query.append( "                    ,? ");
	                query.append( "                    ,? ");
	                query.append( "                    ,SYSDATE ");
	                query.append( "                   ) ");
	                return query.toString();
		
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, usersVO.getUserId());
				stmt.setString(2, usersVO.getUserName());
				stmt.setString(3, usersVO.getUserPassword());
			}
			
			@Override
			public Object getData(ResultSet rs) {
				// TODO Auto-generated method stub
				return null;
			}
		});

	}

	@Override
	public int updateUsers(UsersVO usersVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUsers(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
