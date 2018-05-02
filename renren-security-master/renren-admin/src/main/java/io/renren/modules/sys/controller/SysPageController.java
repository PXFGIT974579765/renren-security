

package io.renren.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.renren.common.annotation.SysLog;

/**
 * 系统页面视图
 */
@Controller
public class SysPageController {
	
	@RequestMapping("modules/{module}/{url}.html")
	public String module(@PathVariable("module") String module, @PathVariable("url") String url){
		return "modules/" + module + "/" + url;
	}

	@RequestMapping(value = {"/", "index.html"})
	public String index(){
		return "index";
	}

	@RequestMapping("index1.html")
	public String index1(){
		return "index1";
	}
	
	@SysLog("调用系统大屏页面")
	@RequestMapping("sucai-dapin")
	public String dapin(Model model,String name,String area){
		model.addAttribute("name", name);
		model.addAttribute("area", area);
		return "sucai-dapin";
	}
	
	@SysLog("调用系统汇总大屏页面")
	@RequestMapping("mainscreen")
	public String mainscreen(Model model,Integer days, String area){
		model.addAttribute("days", days);
		model.addAttribute("area", area);
		return "mainscreen";
	}
	
	@RequestMapping("gongzuozhan")
	public String gongzuozhan(){
		return "gongzuozhan";
	}

	
	@RequestMapping("login.html")
	public String login(){
		return "login";
	}
	@RequestMapping("login2.html")
	public String login2(){
		return "login2";
	}
	@RequestMapping("main.html")
	public String main(){
		return "main";
	}

	@RequestMapping("404.html")
	public String notFound(){
		return "404";
	}

}
