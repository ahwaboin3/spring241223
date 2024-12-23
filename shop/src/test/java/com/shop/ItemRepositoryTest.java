package com.shop;

import java.time.LocalDateTime;
import java.util.List;

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
	
	public void createItemTest() {
		//상품 저장 테스트
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
	@Test
	public void getItemsTest() {
		List<Item> items=itemRepository.findAll();
		for(Item item:items) {
			System.out.println(item);
		}
	}
}



