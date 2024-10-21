package com.peisia.spring.mi.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.peisia.spring.mi.mapper.GuestMapper;
import com.peisia.spring.mi.vo.GuestVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{

	@Setter(onMethod_ = @Autowired)
	private GuestMapper mapper;
	
	@Override
	public Model getList(Model m,int currentPage) {
		int listCountPerPage = 5;	//페이지당 보여줄 글 수
		int pagesPerBlock = 3;	//블럭 당 페이지 수
		int currentBlock = 1;	//현재 페이지 블럭
		int blockStartPage = 1;	//블럭 시작 페이지
		int blockEndPage = 1;	//블럭 끝 페이지
		int blockCount = 1;		//블럭 총 수
		int	prevPage = 1;		//이전 블럭 링크 클릭에 걸 페이지
		int	nextPage = 1;		//다음 블럭 링크 클릭에 걸 페이지
		
		int limitIndex = (currentPage-1) * listCountPerPage;
		m.addAttribute("list",mapper.getList(limitIndex));
		int count = mapper.getCount();
		m.addAttribute("count",mapper.getCount());
		
		//방식은 여기가 길어져도 일단 쉬운 방식으로 함.
		
		////	총 페이지 수 구하기.	////
		int totalPageCount = 0;
		//총 페이지 수 = 전체 글 수 / 페이지당 보여줄 글 수. 단, 짜투리도 계산해야함.
		totalPageCount = (int) Math.ceil((double)count / listCountPerPage);
		log.info("==== 방명록 ==== : 총 게시글 수는 "+count);
		log.info("==== 방명록 ==== : 총 페이지 수는 "+totalPageCount);
		m.addAttribute("totalPageCount", totalPageCount);
		//블럭 당 페이지 수 전달
		m.addAttribute("pagesPerBlock", pagesPerBlock);
		
		//블럭 총 수
		blockCount = (int)Math.ceil((double)totalPageCount/pagesPerBlock);
		m.addAttribute("blockCount", blockCount);
		
		//현재 페이지 번호로 현재 블럭 번호 구하기
		//공식: 현재 블럭 번호 = 현재 페이지 번호 / 블럭 당 페이지 수 << 후 올림 처리 
		currentBlock=(int)Math.ceil((double)currentPage/pagesPerBlock);
		m.addAttribute("currentBlock", currentBlock);
		
		
		//블럭 시작,끝 페이지 구하기
		blockStartPage = (currentBlock-1) * pagesPerBlock + 1;
		blockEndPage = currentBlock * pagesPerBlock;
		//예외처리. 마지막 페이지 보다 크면 마지막 페이지 값 전달.
		if(blockEndPage > totalPageCount) {
			blockEndPage = totalPageCount;
		}
		m.addAttribute("blockStartPage", blockStartPage);
		m.addAttribute("blockEndPage", blockEndPage);
		
		//이전 블럭 이동 가능 여부
		if(currentBlock > 1) {
			m.addAttribute("hasBlockPrev", true);
			//이전 블럭 링크 클릭에 걸 페이지 계산 처리
			prevPage = (currentBlock - 1) * pagesPerBlock;
			m.addAttribute("prevPage", prevPage);
		}
		//다음 블럭 이동 가능 여부
		if(currentBlock < blockCount) {
			m.addAttribute("hasBlockNext", true);
			//다음 블럭 링크 클릭에 걸 페이지 계산 처리
			nextPage = currentBlock * pagesPerBlock + 1;
			m.addAttribute("nextPage", nextPage);
		}
		return m;
	}	

	@Override
	public GuestVO read(long bno) {
		return mapper.read(bno);
	}

	@Override
	public void del(long bno) {
		mapper.del(bno);
	}

	@Override
	public void write(GuestVO gvo) {
		mapper.write(gvo);
	}

	@Override
	public void modify(GuestVO gvo) {
		mapper.modify(gvo);
	}
	
}


