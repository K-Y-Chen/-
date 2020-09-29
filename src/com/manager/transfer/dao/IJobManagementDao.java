package com.manager.transfer.dao;

import java.util.ArrayList;

import com.manager.transfer.domain.JobTransfer;
import com.manager.transfer.domain.Staff;



public interface IJobManagementDao {
	//���λ����������¼
	public boolean insertJobTransfer(JobTransfer jt);
	public boolean updateJobTransfer(JobTransfer jt);
	public boolean deleteJobTransfer(JobTransfer jt);
	
	//ͨ����ˮ��Ų��Ҹ�λ������Ϣ��
	//ע����Щ��ѯ ���ص�Job��Staff����ֻ�б�ź����ơ�
	public ArrayList<JobTransfer> queryjtById(int id);

	
	//ͨ����תǰ���ŵ����Ʋ��Ҳ��ŵ�����Ϣ
	public ArrayList<JobTransfer> queryjtByPreJobName(String preJobName);
	//ͨ����ת���ŵ����Ʋ��Ҳ��ŵ�����Ϣ	
	public ArrayList<JobTransfer> queryjtByJobName(String JobName);
	
	//ͨ����תǰ���ŵ�id���Ҳ��ŵ�����Ϣ
	public ArrayList<JobTransfer> queryjtByPreJobId(int preJobId);
	//ͨ����ת���ŵ�id���Ҳ��ŵ�����Ϣ	
	public ArrayList<JobTransfer> queryjtByJobId(int jobId);
	//ͨ����תԱ��id���Ҳ��ŵ�����Ϣ		
	public ArrayList<JobTransfer> queryjtByStaffId(int staffId);
	//ͨ����ת���Ͳ��Ҳ��ŵ�����Ϣ		
	public ArrayList<JobTransfer> queryjtByType(String type);
	//ͨ����ת���ڲ��Ҳ��ŵ�����Ϣ		
	public ArrayList<JobTransfer> queryjtByDate(String date);
	
	public ArrayList<Staff> queryjtStaffb(String jobName);//��ѯ�ø�λ���ߵ�Ա��
	public ArrayList<Staff> queryjtStaffa(String jobName);//��ѯ�ø�λ�����Ա��
}
