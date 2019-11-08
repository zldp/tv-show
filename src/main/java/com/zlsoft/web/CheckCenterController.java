package com.zlsoft.web;


import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.configurer.socket.service.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {


	//页面请求
	@GetMapping("/socket/{cid}")
	public ModelAndView socket(@PathVariable String cid) {
		ModelAndView mav=new ModelAndView("/socket");
		mav.addObject("cid", cid);
		return mav;
	}
	//推送数据接口
	@ResponseBody
	@RequestMapping("/socket/push/{cid}")
	public Result pushToWeb(@PathVariable String cid, String message) {
		try {
			WebSocketServer.sendInfo(message,null);
		} catch (IOException e) {
			e.printStackTrace();
			return ResultGenerator.genFailResult(cid+"#"+e.getMessage());
		}  
		return ResultGenerator.genSuccessResult(cid);
	} 
} 
