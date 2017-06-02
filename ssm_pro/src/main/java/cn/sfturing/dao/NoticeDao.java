package cn.sfturing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.Notice;

public interface NoticeDao {
	// 查询所有的须知
	public List<Notice> findNoticeByType(@Param("start") int start, @Param("size") int size);

	// 查询所有通知的数量
	public int findNoticeByTypeNum();

	// 通过id查询通知
	public Notice findNoticeById(int id);

}
