package com.manager.transfer.service;

import java.util.ArrayList;

import com.manager.transfer.domain.Dismission;

public interface IDismissionService {
	//向离职表中插入离职记录
		public boolean insertDismission(Dismission dismission);
		public boolean updateDismission(Dismission dismission);
		public boolean deleteDismission(Dismission dismission);
		
		//通过流水编号查找岗位调动信息。
		//注意这些查询 返回的Staff对象只有编号和名称。
		public ArrayList<Dismission> querydById(int id);
		public ArrayList<Dismission> querydByStaffId(int staffId);
		public ArrayList<Dismission> querydByDate(String date);
		public ArrayList<Dismission> querydByType(String type);
		public ArrayList<Dismission> querydByPool(boolean pool);
}
