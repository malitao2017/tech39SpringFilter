package com.mlt.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/control")
public class ApplyController
{
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Model model){
		System.out.println("调用了：/control/get");
		return "welcome";
	}
	
	@RequestMapping(value="/only",method= RequestMethod.GET)
	public String only(Model model,HttpServletRequest request,HttpServletResponse response) throws SQLException{
		System.out.println("调用了：/control/only ");
		System.out.println("拦截器中生成的数据：request："+request.getAttribute("request"));
		System.out.println("监听器中添加的servletContext的数据：dataSource：");
		ServletContext sc = request.getServletContext();
		BasicDataSource bds = (BasicDataSource) sc.getAttribute("dataSource");
		Connection con = bds.getConnection();
		PreparedStatement pre = con.prepareStatement("select * from t_user where t_id=?");
		pre.setInt(1, 1);
		ResultSet rs = pre.executeQuery();
		if(rs.next()){
			String login = rs.getString("t_login_name");
			System.out.println("id唯一的loginname为："+login);
		}
		return "welcome";
	}
}