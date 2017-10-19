package com.mlt.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String only(Model model,HttpServletRequest request,HttpServletResponse response){
		System.out.println("调用了：/control/only ：request："+request.getAttribute("request"));
		return "welcome";
	}
}