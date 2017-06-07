package cn.sfturing.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.Favourite;
import cn.sfturing.entity.Office;

public interface FavouriteDao {
	// 通过userID和hosId查询是否有记录
	public Favourite findFavByuserIdAndHosId(@Param("userId") int userId, @Param("hospitalId") int hospitalId);

	// 插入一条记录
	public int insetFavourite(Favourite favourite);

	// 取消关注
	public int cancelFavourite(int id);

	// 添加guanzhu
	public int addFavourite(int id);

	//查找用户的收藏医院
	public List<Favourite> findFavHos(int userId); 

}
