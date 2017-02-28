package com.ktds.ehm.board.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.ehm.board.board.vo.BoardVO;
import com.ktds.ehm.board.user.vo.UsersVO;
import com.ktds.ehm.dao.support.JDBCDaoSupport;
import com.ktds.ehm.dao.support.QueryHandler;
import com.ktds.ehm.dao.support.annotation.BindData;

import oracle.net.aso.b;

/**
 * Created by Admin on 2017-02-17.
 */
public class BoardDaoImpl extends JDBCDaoSupport implements BoardDao {
    @Override
    public int insertArticle(BoardVO boardVO) {
        return update(new QueryHandler() {
            @Override
            public String preparedQuery() {
                StringBuffer query = new StringBuffer();
                query.append( "INSERT INTO BOARD (");
                query.append( "                   BOARD_ID ");
                query.append( "                   , SUBJECT ");
                query.append( "                   , CONTENT ");
                query.append( "                   , WRITER ");
                query.append( "                   , LIKE_COUNT ");
                query.append( "                   , WRITE_DATE ");
                query.append( "                   , IP ");
                query.append( "                   ) ");
                query.append( "VALUES             (");
                query.append( "                     BOARD_ID_SEQ.NEXTVAL ");
                query.append( "                    ,? ");
                query.append( "                    ,? ");
                query.append( "                    ,? ");
                query.append( "                    ,0 ");
                query.append( "                    ,SYSDATE ");
                query.append( "                    ,? ");
                query.append( "                   ) ");
                return query.toString();
            }

            @Override
            public void mappingParameters(PreparedStatement stmt) throws SQLException {
                stmt.setString(1,boardVO.getSubject());
                stmt.setString(2,boardVO.getContent());
                stmt.setString(3,boardVO.getWriter());
                stmt.setString(4,boardVO.getIp());
            }

            @Override
            public Object getData(ResultSet rs) {
                return null;
            }
        });

    }

    @Override
    public List<BoardVO> selectAllArticles() {
        return selectList(new QueryHandler() {
            @Override
            public String preparedQuery() {
               StringBuffer query = new StringBuffer();
               query.append(" SELECT B.BOARD_ID ");
               query.append("        , B.SUBJECT ");
               query.append("        , B.WRITER ");
               query.append("        , U.USR_ID ");
               query.append("        , U.USR_NM ");
               query.append("        , U.JOIN_DT ");
               query.append("        , B.LIKE_COUNT ");
               query.append("        , TO_CHAR(B.WRITE_DATE,'YYYY.MM.DD') WRITE_DATE");
               query.append("        , B.IP ");
               query.append(" FROM  BOARD B, USRS U");
               query.append(" WHERE  B.WRITER = U.USR_ID ");
               query.append(" ORDER BY B.BOARD_ID DESC ");
               return query.toString();
            }

            @Override
            public void mappingParameters(PreparedStatement stmt) throws SQLException { }

            @Override
            public Object getData(ResultSet rs) {
                BoardVO boardVO = new BoardVO();
                UsersVO usersVO  = boardVO.getUser();
                BindData.startBind(rs, boardVO);
                BindData.bindData(rs,usersVO);
                return boardVO;
            }
        });

    }

    @Override
    public BoardVO selectOneArticle(int boardId) {
        return (BoardVO) selectOne(new QueryHandler() {
            @Override
            public String preparedQuery() {
                StringBuffer query = new StringBuffer();
                query.append(" SELECT B.BOARD_ID ");
                query.append("        , B.SUBJECT ");
                query.append("        , B.WRITER ");
                query.append("        , U.USR_ID ");
                query.append("        , U.USR_NM ");
                query.append("        , U.JOIN_DT ");
                query.append("        , B.LIKE_COUNT ");
                query.append("        , B.CONTENT ");
                query.append("        , B.WRITE_DATE ");
                query.append("        , B.IP ");
                query.append(" FROM  BOARD B, USRS U");
                query.append(" WHERE  B.WRITER = U.USR_ID ");
                query.append(" AND   B.BOARD_ID = ? ");
                query.append(" ORDER BY B.BOARD_ID ");
                return query.toString();
            }

            @Override
            public void mappingParameters(PreparedStatement stmt) throws SQLException {
                stmt.setInt(1,boardId);
            }

            @Override
            public Object getData(ResultSet rs) {
                BoardVO boardVO = new BoardVO();
                UsersVO usersVO  = boardVO.getUser();
                BindData.startBind(rs, boardVO);
                BindData.bindData(rs,usersVO);
                return boardVO;
            }
        });
    }


    @Override
    public int deleteArticle(int boardId) {
        return update(new QueryHandler() {
            @Override
            public String preparedQuery() {
                StringBuffer query = new StringBuffer();
                query.append(" DELETE   BOARD ");
                query.append(" WHERE    BOARD_ID = ? ");

                return query.toString();
            }

            @Override
            public void mappingParameters(PreparedStatement stmt) throws SQLException {
                stmt.setInt(1,boardId);
            }

            @Override
            public Object getData(ResultSet rs) {
                return null;
            }
        });
    }

    @Override
    public int updateArticle(BoardVO boardVO) {
        return update(new QueryHandler() {
            @Override
            public String preparedQuery() {
                StringBuffer query = new StringBuffer();
                query.append(" UPDATE   BOARD              ");
                query.append(" SET	 	      SUBJECT	= ?   ");
                query.append("    	        , CONTENT	= ?   ");
                query.append(" WHERE    BOARD_ID = ?        ");
                return query.toString();
            }

            @Override
            public void mappingParameters(PreparedStatement stmt) throws SQLException {
                stmt.setString(1,boardVO.getSubject());
                stmt.setString(2,boardVO.getContent());
                stmt.setInt(3,boardVO.getBoardId());

            }

            @Override
            public Object getData(ResultSet rs) {
                return null;
            }
        });
    }
}
