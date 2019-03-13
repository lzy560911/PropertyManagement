package com.lzy.action;



import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.lzy.dao.ICamera;
import com.lzy.dao.ILoginUser;
import com.lzy.dao.IOwner;
import com.lzy.pojo.Administrators;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String UserName;
	private String PassWord;
	private String Phone;
	private Map<String, Object> DataMap = new HashMap<String, Object>();
	private ILoginUser loginUser;
	private IOwner ownerDao;
	private String CardNum;
	private ICamera cameraDao;
	private int gbid;
	
	
	public ICamera getCameraDao() {
		return cameraDao;
	}
	public void setCameraDao(ICamera cameraDao) {
		this.cameraDao = cameraDao;
	}
	public int getGbid() {
		return gbid;
	}
	public void setGbid(int gbid) {
		this.gbid = gbid;
	}
	public IOwner getOwnerDao() {
		return ownerDao;
	}
	public void setOwnerDao(IOwner ownerDao) {
		this.ownerDao = ownerDao;
	}
	public String getCardNum() {
		return CardNum;
	}
	public void setCardNum(String cardNum) {
		CardNum = cardNum;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public ILoginUser getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(ILoginUser loginUser) {
		this.loginUser = loginUser;
	}
	public Map<String, Object> getDataMap() {
		return DataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		DataMap = dataMap;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	@SuppressWarnings("rawtypes")
	public String Login() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//创建Student对象并且持久化到数据库
		System.out.println("帐户名是："+UserName);
		System.out.println("密码是："+PassWord);
		List<Administrators> u = loginUser.checkname();
		System.out.println("紫夜查询完毕");
		
				for(Iterator iterator = u.iterator();iterator.hasNext();){
					Object[] os = (Object[])iterator.next();
					if(this.UserName.equals(os[0])){
						if(this.PassWord.equals(os[1])){
							System.out.println("密码正确！！");
							DataMap.put("CheckPassword", "密码正确");
							ActionContext ac = ActionContext.getContext();
							ac.getSession().put("flag","密码正确");
							ac.getSession().put("loginName",UserName);
							break;
					}else{
						System.out.println("密码错误！！");
						DataMap.put("CheckPassword", "密码错误");	
				}
			}
		}
		return "success";
	}
	
	public String findUserName(){
		System.out.println("要查看的帐户名是："+UserName);
		int usernum = loginUser.findUserName(UserName);
		if(usernum == 0){
			System.out.println("message is 1 "+usernum);
			DataMap.put("CheckUserName", "true");
			System.out.println("true");
		}else{
			System.out.println("message is 2 "+usernum);
			DataMap.put("CheckUserName", "false");
			System.out.println("false");
		}
		System.out.println("准备返回");
		return "register";
	}
	
	public String findPhone(){
		int phone = loginUser.findPhone(Phone);
		if(phone == 0){
			System.out.println("phone is 3 "+phone);
			DataMap.put("CheckPhone", "can");
			System.out.println("true");
		}else{
			System.out.println("phone is 4 "+phone);
			DataMap.put("CheckPhone", "notcan");
			System.out.println("false");
		}
		return "phone";
	}
	
	public String findCardNum(){
		System.out.println("要查看的身份证号码是："+CardNum);
		int usernum = ownerDao.findCardNum(CardNum);
		if(usernum == 0){
			System.out.println("message is 1 "+usernum);
			DataMap.put("CheckCardNum", "canuse");
			System.out.println("values is "+DataMap.values());
			System.out.println("true");
		}else{
			System.out.println("message is 2 "+usernum);
			DataMap.put("CheckCardNum", "notcanuse");
			System.out.println("values is "+DataMap.values());
			System.out.println("false");
		}
		System.out.println("准备返回");
		return "findCardNum";
	}
	
	/*//查询国标ID是否可以正常使用
	public String findGBNum(){
		System.out.println("要查看的国标编号是："+CardNum);
		int id = cameraDao.findGBNum(gbid);
		if(id == 0){
			System.out.println("message is 1 "+gbid);
			DataMap.put("CheckGBNum", "canuseid");
			System.out.println("values is "+DataMap.values());
			System.out.println("true");
		}else{
			System.out.println("message is 2 "+gbid);
			DataMap.put("CheckGBNum", "notcanuseid");
			System.out.println("values is "+DataMap.values());
			System.out.println("false");
		}
		System.out.println("准备返回");
		return "findGBNum";
	}*/
}
	



