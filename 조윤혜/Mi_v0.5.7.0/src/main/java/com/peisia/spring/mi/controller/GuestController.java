package com.peisia.spring.mi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.spring.mi.service.GuestService;
import com.peisia.spring.mi.vo.GuestVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j // 로그 출력을 위한 Log4j 라이브러리 사용
@RequestMapping("/guest/*") // URL 경로에 "/guest/"로 시작하는 요청을 처리
@AllArgsConstructor // 롬복(Lombok)을 이용하여 생성자 자동 생성
@Controller // Spring MVC에서 컨트롤러로 인식되는 클래스
public class GuestController {
	private GuestService service; // 의존성 주입(DI)을 통해 GuestService 객체 사용

	@GetMapping("/getList") // "/guest/getList" 요청을 처리 (GET 방식)
	public void getList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage, Model model) {
		// currentPage 값을 요청 파라미터로 받으며, 기본값은 1로 설정
		model = service.getList(model, currentPage); // 현재 페이지 번호를 사용하여 리스트 조회
	}

	@GetMapping({ "/read", "/modify" }) // "/guest/read" 및 "/guest/modify" 요청을 처리 (GET 방식)
	public void read(@RequestParam("bno") Long bno, Model model) {
		// bno라는 이름의 요청 파라미터로 글 번호(Long 타입)를 받음
		log.info("컨트롤러 ==== 글번호 ===============" + bno); // 로그로 글 번호 출력
		model.addAttribute("read", service.read(bno)); // 서비스에서 글을 읽어와 모델에 추가
	}

	@GetMapping("/del") // "/guest/del" 요청을 처리 (GET 방식)
	public String del(@RequestParam("bno") Long bno) {
		// bno라는 이름의 요청 파라미터로 삭제할 글 번호를 받음
		log.info("컨트롤러 ==== 글번호 ===============" + bno); // 로그로 글 번호 출력
		service.del(bno); // 서비스에서 글 삭제 처리
		return "redirect:/guest/getList"; // 삭제 후 리스트 페이지로 리다이렉트
	}

	@PostMapping("/write") // "/guest/write" 요청을 처리 (POST 방식) - 글 작성 처리
	public String write(GuestVO gvo) {
		// GuestVO 객체를 받아서 새로운 글 작성 처리
		service.write(gvo); // 서비스에서 글 작성 처리
		return "redirect:/guest/getList"; // 작성 후 리스트 페이지로 리다이렉트
	}

	@GetMapping("/write") // "/guest/write" 요청을 처리 (GET 방식) - 글 작성 화면을 보여줌
	public void write() {
		// 이 메서드는 글쓰기 화면을 보여주기 위한 요청 처리 (별도의 리턴 값 없음)
		// "/guest/write" 페이지로 이동
	}

	@PostMapping("/modify") // "/guest/modify" 요청을 처리 (POST 방식) - 글 수정 처리
	public String modify(GuestVO gvo) {
		// GuestVO 객체를 받아서 기존 글 수정 처리
		service.modify(gvo); // 서비스에서 글 수정 처리
		return "redirect:/guest/getList"; // 수정 후 리스트 페이지로 리다이렉트
	}
}
