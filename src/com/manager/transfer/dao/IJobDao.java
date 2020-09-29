package com.manager.transfer.dao;

import com.manager.transfer.domain.Job;

public interface IJobDao {
	//通过名称编号名称查找岗位信息
	public Job queryIdJobsByName(String name);
}
