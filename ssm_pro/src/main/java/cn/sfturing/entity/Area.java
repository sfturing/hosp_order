package cn.sfturing.entity;
/**
 * 
 * @author sfturing
 *
 * @date 2017年5月19日
 */
public class Area {
	//城市id
	private int id;
	//城市名称
	private String areaName;
	//父级城市id
	private int parentId;
	//城市等级
	private int level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", areaName=" + areaName + ", parentId=" + parentId + ", level=" + level + "]";
	}

	
}
