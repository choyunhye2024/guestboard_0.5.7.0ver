package com.peisia.spring.mi.mapper;

import java.util.List;

import com.peisia.spring.mi.vo.GuestVO;

public interface GuestMapper {
	public int getCount();
	public List<GuestVO> getList(int limitIndex);
	public GuestVO read(long bno);
	public void del(long bno);
	public void write(GuestVO gvo);
	public void modify(GuestVO gvo);
	
	
}

