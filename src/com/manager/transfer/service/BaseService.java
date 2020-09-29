package com.manager.transfer.service;

import java.util.ArrayList;

import com.manager.transfer.dao.BaseDao;
import com.manager.transfer.dao.IBaseDao;
import com.manager.transfer.domain.Base;


public class BaseService implements IBaseService {

	@Override
	public boolean insertBase(Base base) {
		IBaseDao ibs = new BaseDao();
		return ibs.insertBase(base);
	}

	@Override
	public boolean updateBase(Base base) {
		IBaseDao ibs = new BaseDao();
		return ibs.updateBase(base);
	}

	@Override
	public boolean deleteBase(Base base) {
		IBaseDao ibs = new BaseDao();
		return ibs.deleteBase(base);
	}

	@Override
	public ArrayList<Base> queryById(int id) {
		IBaseDao ibs = new BaseDao();
		return ibs.queryById(id);
	}

	@Override
	public ArrayList<Base> queryByStaffId(int staffId) {
		IBaseDao ibs = new BaseDao();
		return ibs.queryByStaffId(staffId);
	}

}
