package com.manager.transfer.service;

import com.manager.transfer.domain.Job;

public interface IJobService {
	//ͨ�����Ʊ�����Ʋ��Ҹ�λ��Ϣ
	public Job queryIdJobsByName(String name);
}
