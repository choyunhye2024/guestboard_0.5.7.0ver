package com.peisia.spring.mi.service;

import java.util.List;

import com.peisia.spring.mi.vo.GuestVO;

import lombok.Data;

@Data
public class GuestBox {
	private List<GuestVO> posts;
	private int count;
}
