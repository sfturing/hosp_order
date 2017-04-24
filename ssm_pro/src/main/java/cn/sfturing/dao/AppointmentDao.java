package cn.sfturing.dao;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.Appointment;

public interface AppointmentDao {
	/**
	 * 插入学生预约的记录
	 * @param bookId 借阅书目
	 * @param studentId 学生id
	 * @return
	 */
	int insertAppointment(@Param("bookId") long bookId,@Param("studentId") long studentId);
	
	/**
	 * 通过主键查询预约图书记录，并且携带图书实体
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
