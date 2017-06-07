package cn.sfturing.entity;

public class Favourite {
	
	//id
	private int id;
	//用户id
	private int userId;
	//医院id
	private int hospitalId;
	//是否喜欢
	private int isLike;
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
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public int getIsLike() {
		return isLike;
	}
	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}
	@Override
	public String toString() {
		return "Favourite [id=" + id + ", userId=" + userId + ", hospitalId=" + hospitalId + ", isLike=" + isLike + "]";
	}
	

}
