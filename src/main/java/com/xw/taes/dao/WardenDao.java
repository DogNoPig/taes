package com.xw.taes.dao;


import com.xw.taes.domain.Warden;
import com.xw.taes.util.WardenTree;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardenDao {
	/**
	 * ��ѯ����Ա�Ƿ����
	 * @param warden
	 * @return
	 */
	Warden findByNoAndPwd(Warden warden);
	/**
	 * ��ʾ����Ա��Ϣ
	 * @param wId
	 * @return
	 */
	Warden show(int wId);
	/**
	 * ������ӵĹ���Ա��Ϣ�����ݿ���
	 * @param warden
	 * @return 
	 */
	int save(Warden warden);
	/**
	 * �����޸ĺ�����ݵ����ݿ���
	 * @param warden
	 */
	int update(Warden warden);
	/**
	 * �����ݿ��л�ȡ��������
	 * @param id
	 * @return
	 */
	List<WardenTree> getNav(String id);
	/**
	 * ��ѯ����
	 * @param first
	 * @param rows
	 * @param sort
	 * @param order
	 * @param wName 
	 * @param level 
	 * @return
	 */
	List<Warden> find(int first, int rows, String sort, String order, String wName);
	/**
	 * ��ѯ�ܼ�¼��
	 * @param wName 
	 * @return
	 */
	int findCount(String wName);
	/**
	 * ��ȡҪ�༭�Ķ���
	 * @param getwId
	 * @return
	 */
	JSONObject findById(int getwId);
	/**
	 * �����ݿ�����ɾ��
	 * @param ids
	 */
	int delete(String ids);
	

}
