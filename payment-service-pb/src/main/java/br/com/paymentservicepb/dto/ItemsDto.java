package br.com.paymentservicepb.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemsDto {

	private String item;
	private BigDecimal value;
	private Integer qty;
		
}
