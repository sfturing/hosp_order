package cn.sfturing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sfturing.algorithm.MD5;
import cn.sfturing.dao.CommonUserDao;
import cn.sfturing.entity.CommonUser;
import cn.sfturing.service.CommonUserService;
@Service
public class CommonUserServiceImpl implements CommonUserService {

	@Autowired
	private CommonUserDao commonUserDao;

	
	@Transactional
	@Override
	public int login(String userIdenf, String userPassword) throws Exception {
		CommonUser commonUser=commonUserDao.findCommonUserByUserIdenf(userIdenf);
		if(commonUser==null){
			return 0;		//用户不存在就返回0
		}else{
			if(MD5.getMD5(userPassword).equals(commonUser.getUserPassword())){
				return 2;	//用户密码正确返回2
			}else{
				return 1;	//用户密码错误返回1
			}
		}
	}
}
