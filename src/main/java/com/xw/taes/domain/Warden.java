package com.xw.taes.domain;

import lombok.Data;
import lombok.ToString;

/**
 * ����Ա��Ϣ
 * 
 * @author ��ΰ
 *
 */
@Data
@ToString
public class Warden extends DataEntity<Warden> {
	// ����Աid
	private Integer wId;
	// ����Ա���
	private String wNo;
	// ����
	private String wName;
	// ����Ա��ϵ�绰
	private String tel;
	//����Ա����Ժϵ
	//private String collegeName;
	//����Ա�ȼ�
	//private String level;
	// ����Ա��¼����
	private String wPassword;
}
