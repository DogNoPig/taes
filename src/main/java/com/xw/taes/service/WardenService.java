package com.xw.taes.service;


import com.xw.taes.domain.Warden;
import net.sf.json.JSONObject;

import java.util.List;

public interface WardenService {
	/**
	 * ��ѯ�Ƿ���ڴ˹���Ա
	 * @param warden 
	 * @return
	 */
	Warden findByNoAndPwd(Warden warden);
	/**
	 * ��ʾ��ǰ����Ա����Ϣ
	 * @param wName
	 * @return
	 */
	List show(int first, int rows, String sort, String order, String wName);
	/**
	 * ������ӵĹ���Ա��Ϣ
	 * @param warden
	 * @return 
	 */
	int save(Warden warden);
	/**
	 * �����޸ĺ�Ĺ���Ա��Ϣ
	 * @param warden
	 */
	int update(Warden warden);
	/**
	 * ��ȡ������
	 * @param id
	 * @return
	 */
	List getNav(String id);
	/**
	 * ��ȡҪ�༭����������
	 * @param getwId
	 * @return
	 */
	JSONObject findById(int getwId);
	/**
	 * ����ɾ������
	 * @param ids
	 */
	int delete(String ids);


}
