package com.mileweb.glb.apiserver.web;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

//@RestController()
@Controller
@RequestMapping("/restdemo")
public class RestDemo {

	@RequestMapping(value="/putjson", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
	@ResponseBody
	public Dog test(@RequestBody(required=false) Dog dog,@RequestParam(required=false) String key, HttpServletRequest request) {
		System.out.println(dog + "\n" + key);
		
		Dog d = new Dog();
		d.setBirth(new Date());
		d.setName("doggy");
		
		System.out.println(RequestContextUtils.getLocale(request));
		
		System.out.println(request.getLocale());
		
		return d;
	}
	
	@RequestMapping(value="/i18n", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
	@ResponseBody
	public Dog test(HttpServletRequest request) {
		
		Dog d = new Dog();
		d.setBirth(new Date());
		
		RequestContext requestContext = new RequestContext(request);
		
		String s = requestContext.getMessage("msg");
		d.setName(s);
		System.out.println(s);
		System.out.println(RequestContextUtils.getLocale(request));
		
		System.out.println(request.getLocale());
		
		return d;
	}
	
	@RequestMapping("/definitejson")
	@ResponseBody
	public ModelAndView myjson() {
		Dog d = new Dog();
		d.setBirth(new  Date());
		d.setName("doggy");
		
		ModelAndView m = new ModelAndView();
		m.setViewName("definiteJson");
		m.addObject("json", d);
		return m;
	}
	
	@RequestMapping("/html")
	public String test2(Map<String, Object> m) {
		System.out.println(m);
		return "demo";
	}
	
	@GetMapping("/path/{name}")
	public String get(@PathVariable String name, Model model) {
		System.out.println(name);
		return "demo";
	}

}


class Dog {

	String name;
	int age;
	Date birth;

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}
}
