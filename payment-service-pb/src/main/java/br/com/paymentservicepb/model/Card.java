package br.com.paymentservicepb.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {
	
	private String number_token; //instanciar método
	
	@NotBlank @Size(max=100)
	private String cardholder_name;
	
	@NotBlank @Size(min=3,max=3)
	private Integer security_code;
	
	@NotNull @Enumerated(EnumType.STRING)
	private Brand brand;
	
	@NotBlank @Size(min=2,max=2)
	private Integer expiration_month;
	
	@NotBlank @Size(min=4,max=4)
	private Integer expiration_year;

}
