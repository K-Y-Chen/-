package com.manager.transfer.dao;

import com.manager.transfer.domain.Job;

public interface IJobDao {
	//ͨ�����Ʊ�����Ʋ��Ҹ�λ��Ϣ
	public Job queryIdJobsByName(String name);
}
