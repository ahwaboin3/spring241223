package com.shop.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemDto;

@Controller
//url에 "/thymeleaf"경로로 오는 요청을 thymeleafExController가
//처리하도록 합니다.
@RequestMapping(value="/thymeleaf")
public class ThymeleafExController {
	
	@GetMapping(value="/ex01")
	public String thymeleafExample01(Model model) {
		//model객체를 이용해 뷰에 전달한 데이터를 key,value 구조로 넣줍니다.
		model.addAttribute("data","타임리프 예제입니다.");
		//templates폴더를 기준으로 뷰의 위치와 이름을 반환합니다.
		return "thymeleafEx/thymeleafEx01";
	}
	
	@GetMapping(value="/ex02")
	public String thymeleafExample02(Model model) {
		model.addAttribute("say","Hello Thymeleaf");
		ItemDto itemDto=new ItemDto();
		itemDto.setItemNm("테스트 상품1");
		itemDto.setPrice(10000);
		itemDto.setItemDetail("테스트 상품 상세 설명");
		itemDto.setRegTime(LocalDateTime.now());
		model.addAttribute("itemDto",itemDto);
		return "thymeleafEx/thymeleafEx02";
	}

}







