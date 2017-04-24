package cn.sfturing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.Book;

/**
 * 
 * @author sfturing
 *
 */
public interface BookDao {
	/**
	 * 通过ID查询一本书
	 * @param id
	 * @return
	 */
	Book queryById(long id);
	/**
	 * 查询所有图书
	 * @param offset 查询的起始的位置
	 * @param limit	查询的数量
	 * @return
	 */
	List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	/**
	 * 减少馆藏数量
	 * @param bookId 减少的书目
	 * @return 如果影响行数等于>1，表示更新的记录行数
	 */
	int reduceNumber(long bookId);	

}
