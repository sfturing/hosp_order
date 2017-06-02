package cn.sfturing.entity;

public class Notice {
	private int id;
	// 须知名称
	private String noticeName;
	// 须知内容
	private String noticeDescription;
	// 须知类型
	private String noticeType;
	// 创建时间
	private String createTime;
	// 创建时间
	private String updateTime;
	//是否显示
	private int isUseful;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoticeName() {
		return noticeName;
	}
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}
	public String getNoticeDescription() {
		return noticeDescription;
	}
	public void setNoticeDescription(String noticeDescription) {
		this.noticeDescription = noticeDescription;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getIsUseful() {
		return isUseful;
	}
	public void setIsUseful(int isUseful) {
		this.isUseful = isUseful;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", noticeName=" + noticeName + ", noticeDescription=" + noticeDescription
				+ ", noticeType=" + noticeType + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", isUseful=" + isUseful + "]";
	}
	

}
