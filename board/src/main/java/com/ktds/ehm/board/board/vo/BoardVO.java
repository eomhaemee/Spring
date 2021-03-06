package com.ktds.ehm.board.board.vo;

import com.ktds.ehm.board.user.vo.UsersVO;
import com.ktds.ehm.dao.support.annotation.Types;

/**
 * Created by Admin on 2017-02-17.
 */
public class BoardVO {
    @Types
    private int boardId;
    @Types
    private String subject;
    @Types
    private String content;
    @Types
    private String writer;
    @Types
    private int likeCount;
    @Types
    private String writeDate;
    @Types
    private String ip;
    @Types
    private int rnum;

    
    private UsersVO user;

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public UsersVO getUser() {
    	if( user == null) {
    		user = new UsersVO();
    	}
		return user;
	}

	public void setUser(UsersVO user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }
}
