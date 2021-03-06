package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWord {
	
	/**
	 * 1.使用@RequestMapping注解来映射请求的URL
	 * 2.返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下操作：
	 *   通过prefix + returnVal + suffix（后缀）这样的方式得到实际的物理视图，然后做转发操作 转发的地址是 WEB-INF/views/success.jsp
	 * @return
	 */
	@RequestMapping("/helloword")
	public String Hello() {
		System.out.println("Hello Word");
		return "success";
	}
}
