package com.xw.taes.controller;

import com.xw.taes.domain.Warden;
import com.xw.taes.service.WardenService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/warden")
public class WardenAction extends BaseAction {

	// ע��ҵ����wardenService
	@Autowired
	private WardenService wardenService;

	/**
	 * ��ת����¼ҳ��
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		System.out.println("login");
		return "/wLogin";
	}
	/**
	 * ����Ա��¼
	 * @return
	 */
	@PostMapping("/login")
	public String wlogin(Warden warden){
		System.out.println("--------wardenֵ=" + warden + "," + "��ǰ��=WardenAction.wlogin()");
		Warden existLogin = wardenService.findByNoAndPwd(warden);
		if (existLogin != null){
			return "/warden/index";
		}else {
			return "/warden/error";
		}
	}
	/**
	 * �˳���¼
	 * @return
	 */
	public String exit(){
		//ActionContext.getContext().getSession().clear();
		return "exit";
	}
	/**
	 * ��ʾ����Ա��Ϣ
	 * @return
	 */
	public String info(){
		/*warden = (Warden) ActionContext.getContext().getSession().get("warden");
		warden = wardenService.show(warden.getwId());*/
		return "info";
	}
	/**
	 * ����ajax�����Ĳ�������ӵ����ݿ�
	 * @return
	 */
	public String add(HttpServletRequest request,Warden warden){
		/*System.err.println("����Σ�"+warden.getwNo());
		System.err.println("����Σ�"+warden.getwName());
		System.err.println("����Σ�"+warden.getTel());
		System.err.println("����Σ�"+warden.getwPassword());*/
		int f = wardenService.save(warden);
		PrintWriter out;
		System.err.println("����Σ�"+f);
		return "";
	}
	/**
	 * ������ӵĹ���Ա��Ϣ
	 * @return
	 */
	public String addto(Warden warden){
		wardenService.save(warden);
		//this.addActionMessage("��ӳɹ���");
		return "addto";
	}
	/**
	 * �༭����Ա��Ϣ
	 * @return
	 */
	//��Ҫ�༭��json���ݴ���ǰ��
	private JSONObject editData = null;
	public JSONObject getEditData() {
		return editData;
	}
	public void setEditData(JSONObject editData) {
		this.editData = editData;
	}

	public String edit(Warden warden){
		System.err.println("edit="+warden.getWId());
		JSONObject editData = wardenService.findById(warden.getWId());
		return "";
		
	}
	
	
	
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @return
	 */
	public String update(Warden warden){
		//warden = (Warden) ActionContext.getContext().getSession().get("warden");
		int u = 0;
		u = wardenService.update(warden);
		return "";
	}
	///**
	// * �����޸ĺ����Ϣ
	// * @return
	// */
	//public String updateto(){
	//	wardenService.update(warden);
	//	this.addActionMessage("�޸ĳɹ���");
	//	return "updateto";
	//}
	
	/**
	 * ��ȡ������Ϣ
	 * @return
	 */
	//������json����
	private JSONArray tree = null;
	public JSONArray getTree() {
		return tree;
	}
	public void setTree(JSONArray tree) {
		this.tree = tree;
	}
	//���Ľڵ�id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNav(){
		//tree = wardenService.getNav(id);
		//System.err.println("id="+id);
		//return SUCCESS;
		return "";
	}
	/**
	 * �������Ա��Ϣ
	 * @return
	 */
	//��̨�������� ��ǰҳ ÿҳ��ʾ�� �����ֶ� ˳��
	//private PageBean pb = new PageBean();
/*	private int rows;
	private int page;
	private String sort;
	private String order;
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	//ǰ̨����json���
	private JSONObject mwa = null;
	public JSONObject getMwa() {
		return mwa;
	}
	public void setMwa(JSONObject mwa) {
		this.mwa = mwa;
	}*/
	public String mWarden(Warden warden){
		/*System.err.println("��һ�Σ�"+rows);
		System.err.println("��er�Σ�"+page);
		System.err.println("��san�Σ�"+sort);
		System.err.println("��si�Σ�"+order);
		System.err.println("����Σ�"+warden.getwName());*/
		//mwa = wardenService.show(first,rows,sort,order ,warden.getwName());
		return "";
	}
	/**
	 * ɾ������Ա��Ϣ
	 * @return
	 */
	//����ids
	/*private String ids=null;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}*/
	public String delete(String ids){
		int count = wardenService.delete(ids);
		return "";
	}
	
}
