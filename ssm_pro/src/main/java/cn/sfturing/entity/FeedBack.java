package cn.sfturing.entity;

public class FeedBack {
	private int id;
	private int userId;
	private String content;
	private String createTime;
	@Override
	public String toString() {
		return "FeedBack [id=" + id + ", userId=" + userId + ", content=" + content + ", createTime=" + createTime
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	

}
