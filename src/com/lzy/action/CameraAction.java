package com.lzy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.ICamera;
import com.lzy.pojo.Camera;
import com.lzy.pojo.Worker;
import com.opensymphony.xwork2.ActionSupport;


public class CameraAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Camera camera;
	private ICamera cameraDao;
	private int id;
	private int page;
	private String camera_gbid;
	private String camera_name;
	private String camera_time;
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	public ICamera getCameraDao() {
		return cameraDao;
	}
	public void setCameraDao(ICamera cameraDao) {
		this.cameraDao = cameraDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getCamera_gbid() {
		return camera_gbid;
	}
	public void setCamera_gbid(String camera_gbid) {
		this.camera_gbid = camera_gbid;
	}
	public String getCamera_name() {
		return camera_name;
	}
	public void setCamera_name(String camera_name) {
		this.camera_name = camera_name;
	}
	public String getCamera_time() {
		return camera_time;
	}
	public void setCamera_time(String camera_time) {
		this.camera_time = camera_time;
	}
	//�����Ϣ
	public String CameraAdd() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("������������������������������������");
		cameraDao.add(camera);
		return this.CameraFindAll();
	}
	
	//��ѯȫ����Ϣ
	public String FindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��ѯ����ͷ��Ϣ");
		ServletActionContext.getRequest().getSession()
		.setAttribute("cameras", cameraDao.findAll());
		System.out.println("��ѯ����ͷ��Ϣ���");
		return "findsuccess";
	}
	
	public String CameraFindAll() throws Exception {
		// TODO Auto-generated method stub
		
		List<Camera> cm = cameraDao.findAll(page,15);
		System.out.println("--------->"+cm.size());
		for(int i=0;i<cm.size();i++){
			cm.get(i).setC_gbid(cm.get(0).getC_gbid().substring(0,3)+"***************"+cm.get(0).getC_gbid().substring(18,20));
			System.out.println("get() is "+cm.get(i).getC_gbid());
		}
		ServletActionContext.getRequest().getSession()
		.setAttribute("cameras",cm);	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(cameraDao.getSize()<=15){
			size=1;
		}else{
			if(cameraDao.getSize()%15==0){
				size=(int) Math.ceil(cameraDao.getSize()/15);
			}else{
				size=(int) Math.ceil(cameraDao.getSize()/15+1);	
				}
		}
		ServletActionContext.getRequest().getSession().setAttribute("size", size);
		int[] s =new int[size];
		for(int i=0;i<size;i++){
			
			s[i]=i+1;
		}
		System.out.println(page);
		ServletActionContext.getRequest().getSession().setAttribute("fenye", s);
		return "findsuccess";
	}
	
	//����IDɾ��
	public String CameraDelete() throws Exception {
		// TODO Auto-generated method stub
		cameraDao.delete(id);
		return this.CameraFindAll();
	}
	
	//����
	public String CameraUpdate() throws Exception {
		// TODO Auto-generated method stub
		cameraDao.update(camera);
		return this.CameraFindAll();
	}
	
	//����id��ѯ��Ӧ��Ϣ��Ϊ����׼��
	public String CameraFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("c", cameraDao.findByid(id));
		System.out.println("׼�������޸Ľ���");
		System.out.println();
		return "edit";
	}
	public String CameraSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("camera_name is "+camera_name);
		ServletActionContext.getRequest().getSession()
		.setAttribute("cameras",cameraDao.findByCondition_two(camera_gbid,camera_name,camera_time));
		System.out.println("���ع�����Ա�߼���ѯ");
		return "findsuccess";
	}
}
