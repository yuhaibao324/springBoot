package com.yhbaoplog.web;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yhbaoplog.web.result.JsonResult;
import com.yhbaoplog.web.result.ResultCode;



/**
 * 管理接口：登录……等
 * @author XuJijun
 *
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	 
	 protected static Logger logger=LoggerFactory.getLogger(AdminController.class);
	 
	@Value("${spring.profiles}")
	private String env;
	
	private String userName = "admin";
	private String pw = "admin";
	
	/**
	 * 登录
	 * @param response：用于保存token到cookie中
	 * @param map：包含userName和password
	 * @return
	 */
	@RequestMapping("/login")
	public JsonResult login(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map) {
		if(userName.equals(map.get("userName")) && pw.equals(map.get("password"))){
			logger.info("login: " + map.get("userName") + " password:" + map.get("password") );
			return new JsonResult(ResultCode.SUCCESS, "登录成功！", null);
		}else {
			logger.info("login: " + map.get("userName") + " password:" + map.get("password") );
			return new JsonResult(ResultCode.NOT_LOGIN, "登录失败！", null);
		}
	}
}