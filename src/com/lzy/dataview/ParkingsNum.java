package com.lzy.dataview;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzy.pojo.Parkingsnum;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class helloBarRainfall
 */

public class ParkingsNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkingsNum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParkingsNumDAO barRainfall=new ParkingsNumDAO();
        
        ArrayList<Parkingsnum> array = (ArrayList<Parkingsnum>) barRainfall.listAll();
        System.out.println("s"+array);
        response.setContentType("text/html; charset=utf-8");
        JSONArray json=JSONArray.fromObject(array);
        System.out.println(json.toString());
        PrintWriter out = response.getWriter();  
        out.println(json);  
        out.flush();  
        out.close();   
	}

}
