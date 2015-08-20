package com.rs.action.api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AddQuestion extends ActionSupport {
	private String title;
	private String answer;
	private String result;
	public void add() throws ClassNotFoundException, SQLException, IOException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/recruitment_system";
		String usernameMysql="root";
		String passwordMysql="root";
		Connection conn=DriverManager.getConnection(url,usernameMysql,passwordMysql);
		Statement stmt=conn.createStatement();
		String sql="insert into question(title,answer,level,sid) values('"+title+"','"+answer+"',1,1)";
		int flag=stmt.executeUpdate(sql);
		result=(flag==1)?"ok":"err";
		stmt.close();
		conn.close();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(flag);
		
	}
}