package com.manager.transfer.service;

import java.util.ArrayList;
import com.manager.transfer.domain.Base;

public interface IBaseService {
	public boolean insertBase(Base base);
	public boolean updateBase(Base base);
	public boolean deleteBase(Base base);//ͨ��Ա�����ɾ���˲ſ��¼
	
	public ArrayList<Base> queryById(int id);
	public ArrayList<Base> queryByStaffId(int staffId);
}
