package com.lzy.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import com.opensymphony.xwork2.ActionSupport;
public class SocketAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String SocketSend() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("message is "+message);
		Socket sc=null;
		DataOutputStream dout=null;
		DataInputStream din=null;
		try {
			sc=new Socket("192.168.20.91",9656);// ָ��������Ϣ��Socket����
			dout=new DataOutputStream(sc.getOutputStream());//ָ���������socket����ָ��ķ�������������ͨ��
			dout.writeUTF(message);//������Ϣ
			System.out.println("The system message was sent successfully !");
			din=new DataInputStream(sc.getInputStream());
			String getMes=din.readUTF();
			System.out.println("��������ִ��Ϣ��"+getMes);
			System.out.println("Thank you for your feedback. good - bye");
			//���ջ�ִ��Ϣ
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(dout!=null)
					dout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "success";
	}
}
