package com.peisia.spring.mi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.peisia.spring.mi.dto.TestDto;
import com.peisia.spring.mi.mapper.TestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class TestServiceImpl implements TestService{

	@Setter(onMethod_ = @Autowired)
	private TestMapper mapper;	
	
	@Override
	public String getOne() {
		log.info("test===========");
		TestDto tvo = mapper.getData1();
		String one = tvo.getStr_data();
		return one;
	}

	@Override
	public String getTwo() {
		log.info("test===========");
		TestDto tvo = mapper.getData2();
		String two = tvo.getStr_data();
		return two;
	}
	
	/* 문제 1 */
	@Override
	public void updateVisitantCount() {
		mapper.updateVisitantCount();
	}
	
	/* 문제 2 */
	@Override
	public void insertDoodle() {
		mapper.insertDoodle();
	}	

	/* 문제 3 */
	@Override
	public void delTest() {
		mapper.delTest();
	}
	
	
}
