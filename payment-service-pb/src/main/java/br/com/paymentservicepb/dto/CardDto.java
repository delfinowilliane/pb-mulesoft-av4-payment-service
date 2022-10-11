package br.com.paymentservicepb.dto;

import br.com.paymentservicepb.model.OrderRequest;
import br.com.paymentservicepb.statics.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
	
	private String card_number;
	private String cardholder_name;
	private Integer security_code;
	private Brand brand;
	private Integer expiration_month;
	private Integer expiration_year;
	private OrderRequest payment;

}
