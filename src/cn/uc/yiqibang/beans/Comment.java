package cn.uc.yiqibang.beans;

import java.util.Date;

public class Comment {

	private int id;
	private int newsId;
	private int userId;
	private String content;
	private Date createTime;
	private int thumbsCount;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(int newsId, int userId, String content, Date createTime, int thumbsCount) {
		super();
		this.newsId = newsId;
		this.userId = userId;
		this.content = content;
		this.createTime = createTime;
		this.thumbsCount = thumbsCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getThumbsCount() {
		return thumbsCount;
	}
	public void setThumbsCount(int thumbsCount) {
		this.thumbsCount = thumbsCount;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", newsId=" + newsId + ", userId=" + userId + ", content=" + content
				+ ", createTime=" + createTime + ", thumbsCount=" + thumbsCount + "]";
	}
	
	
	
}
