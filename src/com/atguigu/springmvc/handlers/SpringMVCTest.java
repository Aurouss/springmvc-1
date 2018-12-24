package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springmvc.entities.User;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	
	private static final String SUCCESS = "success";
	/**
	 * 重要：
	 * springmvc 会按请求参数名和POJO属性名进行自动匹配，自动为该对象填充属性值。支持级联属性，如这里的address.province
	 * @param user
	 * @return
	 */
	@RequestMapping("/testPOJO")
	public String testPOJO(User user) {
		System.out.println("testPOJO: " + user);
		return SUCCESS;
	}
	
	
	/**
	 * 了解：
	 * @CookieValue 映射一个Cookie 值。属性同@RequestParam。
	 * @param jsessionid
	 * @return
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue(value="JSESSIONID") String jsessionid) {
		System.out.println("testCookieValue  JSESSIONID:" + jsessionid);
		return SUCCESS;
	}
	
	/**
	 * 使用机会较少，了解：
	 * 映射请求头信息
	 * 用法用@ReqeustParam
	 * @param vl
	 * @return
	 */
	@RequestMapping(value="testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language") String vl) {
		System.out.println("testRequestHeader Accept-Language:" + vl);
		return SUCCESS;
	}
	
	/**
	 * @RequestParam 来映射请求参数。
	 * value值即是请求的参数名
	 * required 是该参数是否必须，默认是true
	 * defaultValue 为请求参数的默认值
	 */
	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam(value = "username") String username,
			@RequestParam(value = "age", required = false, defaultValue = "1") int age) {
		System.out.println("testRequestParam:" + username + age);
		return SUCCESS;
	}
	/**
	 * Rest 风格的URL
	 * 一CRUD为例
	 * 新增：/testREST  POST	
	 * 修改：/testREST/1  PUT		以前的是update?id=1
	 * 获取：/testREST/1  GET			 get?id=1
	 * 删除：/testREST/1  DELETE		 delete?id=1
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/testREST/{id}",method=RequestMethod.PUT)
	public String testRESTPUT(@PathVariable Integer id) {
		System.out.println("testREST PUT" + id);
		return SUCCESS;
	}
	@RequestMapping(value="/testREST/{id}",method=RequestMethod.DELETE)
	public String testRESTDELETE(@PathVariable Integer id) {
		System.out.println("testREST DELETE" + id);
		return SUCCESS;
	}
	@RequestMapping(value="/testREST/{id}",method=RequestMethod.POST)
	public String testRESTPOST() {
		System.out.println("testREST POST");
		return SUCCESS;
	}
	@RequestMapping(value="/testREST/{id}",method=RequestMethod.GET)
	public String testRESTGET(@PathVariable Integer id) {
		System.out.println("testREST GET:" + id);
		return SUCCESS;
	}
	
	
	/**
	 * @PathVariable可以将URL中的占位符映射到方法的参数中。
	 * @param id
	 * @return
	 */
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("testPathVariable:" + id);
		return SUCCESS;
	}
	
	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath() {
		System.out.println("testAntPath");
		return SUCCESS;
	}
	
	/**
	 * 了解：可以使用params 和headers来更加精确的映射请求，parmas和headers支持简单的表达式
	 * @return
	 */
	@RequestMapping(value="/testParamsAndHeaders" , params= {"username", "age!=10"}, headers= {"Accept-Language=zh-CN,zh;q=0.8"})
	public String testParamsAndHeaders () {
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod () {
		System.out.println("testMethod");
		return SUCCESS;
	}
	
	/**
	 * 1.@RequestMapping不仅可以修饰方法还可一修饰类
	 * 2.
	 * 1).类定义处：提供初步的映射请求信息。相对于WEB应用的根目录
	 * 2).方法处：提供进一步细分的映射信息。
	 * 	相对于类定义处的URL，若类定义出没有标注@RequestMapping，那么方法处定义的URL相对于WEB应用的跟目录。
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping () {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
}
