package com.manager.transfer.service;

import java.util.ArrayList;
import com.manager.transfer.domain.Base;

public interface IBaseService {
	public boolean insertBase(Base base);
	public boolean updateBase(Base base);
	public boolean deleteBase(Base base);//通过员工编号删除人才库记录
	
	public ArrayList<Base> queryById(int id);
	public ArrayList<Base> queryByStaffId(int staffId);
}
