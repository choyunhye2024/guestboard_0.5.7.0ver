package com.peisia.spring.mi.service;

public interface TestService {
	public String getOne();
	public String getTwo();
	
	public void updateVisitantCount();	/* 문제 1 */
	public void insertDoodle();			/* 문제 2 */
	public void delTest();				/* 문제 3 */	
}
