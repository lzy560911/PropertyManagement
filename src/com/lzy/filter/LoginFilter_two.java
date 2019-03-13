package com.lzy.filter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

public class LoginFilter_two implements Filter {

	    // ��Ҫ����ϵͳҳ������пɷ��е�����  
	    private List<String> list = new ArrayList<String>();  
	  
	    public void init(FilterConfig arg0) throws ServletException {  
	        list.add("/login.jsp");  
	        list.add("/AdministratorsAction.do");  
	    }  
	  
	    public void doFilter(ServletRequest servletRequest,  
	            ServletResponse servletResponse, FilterChain chain)  
	            throws IOException, ServletException {  
	        HttpServletRequest request = (HttpServletRequest) servletRequest;  
	        HttpServletResponse response = (HttpServletResponse) servletResponse;  
	        // 1����ȡҳ���еķ��ʵ�·������  
	        String path = request.getServletPath();
	        System.out.println("path is"+path);
	        if (list != null && list.contains(path)) {  
	            // ���ҳ���л�ȡ�ķ��������ڶ���Ŀɷ��е�����һ�£������  
	            chain.doFilter(request, response);  
	            return;  
	        }  
	        // 2����session(flag)�����л�ȡ��ǰ��¼���û���־  
	        Object flag = request.getSession().getAttribute("flag");
	        System.out.println("flag is "+flag);
	        if (flag != null) {  
	            // �����session�л�ȡ���û�����Ϊ�գ������  
	            chain.doFilter(request, response);  
	            return;
	        }  
	        // �������������1��2�����ܷ��У��ص�ϵͳ�ĵ�¼ҳ�� 
	        response.sendRedirect(request.getContextPath() + "/login.jsp");
	        System.out.println("getContextPath is" +request.getContextPath() + "/login.jsp");
	    }  
	  
	    public void destroy() {
	    	
	    }  
}
