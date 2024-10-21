package com.peisia.spring.mi.service;


import lombok.extern.log4j.Log4j;

@Log4j
public class Cat {
	private Dog duri;
	public Cat() {
		
	}
	public Cat(Dog d) {
		duri=d;
	}
}
