package com.shop;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;

@SpringBootTest
public class ItemRepositoryTest {
	@Autowired
	ItemRepository itemRepository;
	
	//상품 저장 테스트
	public void createItemTest() {
		Item item=new Item();
		item.setItemNm("테스트 상품");
		item.setPrice(1000);
		item.setItemDetail("테스트 상품 상세 설명");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setStockNumber(100);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		//데이터 베이스에 저장
		itemRepository.save(item);
	}
	
	//전체 조회 테스트
	public void getItemsTest() {
		List<Item> items=itemRepository.findAll();
		for(Item item:items) {
			System.out.println(item);
		}
	}
	
	//수정하기
	public void putItemTest() {
		Item item=new Item();
		item.setId(1L);
		item.setItemNm("수정된 테스트 상품 이름");
		item.setPrice(1000);
		item.setItemDetail("테스트 상품 상세 설명");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setStockNumber(100);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		//데이터 베이스에 수정
		itemRepository.save(item);
	}
	//삭제하기
	public void deleteItemTest() {
		Item item=new Item();
		item.setId(2L);
		itemRepository.delete(item);
	}
	
	//데이터 한개 가져오기
	public void getItemTest() {
		Optional<Item> item=itemRepository.findById(1L);
		if(item.isPresent()) {
			System.out.println(item.get());
		}else {
			System.out.println("그 아이디 값의 행을 찾지 못했습니다.");
		}
	}
	
	//상품 이름으로 검색 테스트
	@Test
	public void getByNmTest() {
		List<Item> items=itemRepository.findByItemNm("테스트 상품");
		System.out.println(items.size());
		for(Item item:items) {
			System.out.println(item);
		}
	}
}












