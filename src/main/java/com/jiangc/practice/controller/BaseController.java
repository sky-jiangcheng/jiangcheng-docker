package com.jiangc.practice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiangc.practice.common.BaseResponse;




@Controller
@RequestMapping(value="/base")
public class BaseController {

	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public BaseResponse test(HttpServletRequest request,HttpServletResponse response) {
		return new BaseResponse.Builder("200","success").build();
		
	}
}
