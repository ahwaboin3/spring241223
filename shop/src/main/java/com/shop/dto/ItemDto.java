package com.shop.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemDto {
	private Long id;
	private String itemNm;
	private Integer price;
	private String itemDetail;
	private String sellStatCd;
	private LocalDateTime regTime;
	private LocalDateTime updateTime;

}
