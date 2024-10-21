package com.peisia.spring.mi.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.spring.mi.service.TestService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
//@AllArgsConstructor
@Controller
public class TestController {
	
	@Setter(onMethod_ = @Autowired)
	private TestService service;
	
	@GetMapping("/jstl")
	public void jstl() {
	}
	
	@GetMapping("/x")
	public String x(@RequestParam("n") Integer n) {
		log.error("============ x! =========");
		return "redirect:/";
	}
	
	@GetMapping("/y")
	public String y(@RequestParam(value="n", required=false) Integer n) {
		log.error("============ y! =========");
		return "redirect:/";
	}
	
	
	@GetMapping("/getOnePlusTwo")
	public void getOnePlusTwo(Model model) {
//	public void getOnePlusTwo() {
		log.info("getOnePlusTwo ==========================================");
		log.error("에러임");
		log.warn("에러임");
		log.debug("에러임");
		
		String one = service.getOne();
		String two = service.getTwo();
		Integer sum = Integer.parseInt(one) + Integer.parseInt(two); 
		log.info("(여기 컨트롤러임) 1 더하기 2는 = " + sum);
		
		model.addAttribute("sum",sum);
	}
	
	@GetMapping("/dog")
	public String cat(Model x) {
		log.info("고양이===================");
		x.addAttribute("x","xxx");
		
		//빈이랑 싸우는 중
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        log.info("============ 빈빈빈");
        log.info("===:"+(Arrays.toString(beanDefinitionNames)));
		
		
		return "test/cat";
	}
	
	/* 문제 1 */
	@GetMapping("/updateVisitantCount")
	public void updateVisitantCount() {
		log.info("========================================== : 컨트롤러에서 updateVisitantCount() 실행중");
		service.updateVisitantCount();
		
		log.info("(여기 컨트롤러임) 업데이트 잘 됐음");
	}
	
	/* 문제 2 */
	@GetMapping("/insertDoodle")
	public void insertDoodle() {
		log.info("========================================== : 컨트롤러에서 insertDoodle() 실행중");
		service.insertDoodle();
		log.info("(여기 컨트롤러임) insert 잘 됐음");
	}	

	/* 문제 3 */
	@GetMapping("/delTest")
	public void delTest() {
		log.info("========================================== : 컨트롤러에서 delTest() 실행중");
		service.delTest();
		log.info("(여기 컨트롤러임) delTest 잘 됐음");
	}	
}
