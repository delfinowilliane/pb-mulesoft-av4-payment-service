package br.com.paymentservicepb.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Items {
	
	@NotBlank @Size(max=25)
	private String item;
	
	@NotNull @Positive
	private BigDecimal value;
	
	@NotNull @Positive
	private Integer qty;
	
	private OrderRequest items;

}
