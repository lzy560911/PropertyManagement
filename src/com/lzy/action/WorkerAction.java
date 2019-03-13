package com.lzy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IWorker;
import com.lzy.pojo.Worker;
import com.opensymphony.xwork2.ActionSupport;

public class WorkerAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Worker worker;
	private IWorker workerDao;
	private int id;
	private int page;
	private String worker_name;
	private String work_cardnumber;
	private String work_dname;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public IWorker getWorkerDao() {
		return workerDao;
	}

	public void setWorkerDao(IWorker workerDao) {
		this.workerDao = workerDao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getWorker_name() {
		return worker_name;
	}

	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}

	public String getWork_cardnumber() {
		return work_cardnumber;
	}

	public void setWork_cardnumber(String work_cardnumber) {
		this.work_cardnumber = work_cardnumber;
	}

	public String getWork_dname() {
		return work_dname;
	}

	public void setWork_dname(String work_dname) {
		this.work_dname = work_dname;
	}

	public String WorkerFindAll() throws Exception {
		// TODO Auto-generated method stub
		
		List<Worker> wk = workerDao.findAll(page,15);
		System.out.println("--------->"+wk.size());
		for(int i=0;i<wk.size();i++){
			wk.get(i).setW_cardnumber(wk.get(0).getW_cardnumber().substring(0,3)+"***********"+wk.get(0).getW_cardnumber().substring(14,18));
			System.out.println("get() is "+wk.get(i).getW_cardnumber());
		}
		ServletActionContext.getRequest().getSession()
		.setAttribute("worker",wk);
		System.out.println("--------->"+worker);
		
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(workerDao.getSize()<=15){
			size=1;
		}else{
			if(workerDao.getSize()%15==0){
				size=(int) Math.ceil(workerDao.getSize()/15);
			}else{
				size=(int) Math.ceil(workerDao.getSize()/15+1);	
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

	//按照ID删除
	public String WorkerDelete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("准备删除业主车辆信息");
		workerDao.delete(id);
		return this.WorkerFindAll();
	}

	//添加信息
	public String WorkerAdd() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("准备插入!!!");
		workerDao.add(worker);
		System.out.println("插入完成");
		return this.WorkerFindAll();
	}
	
	
	public String WorkerFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("w", workerDao.findByid(id));
		System.out.println("准备返回修改界面");
		System.out.println();
		return "edit";
	}
	
	public String WorkerSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("worker",workerDao.findByCondition_two(worker_name,work_cardnumber,work_dname));
		System.out.println("返回工作人员高级查询");
		return "findsuccess";
	}
	//更新
	public String WorkerUpdate() throws Exception {
		// TODO Auto-generated method stub
		workerDao.update(worker);
		return this.WorkerFindAll();
	}
}
