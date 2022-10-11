package br.com.paymentservicepb.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.paymentservicepb.statics.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank @Size(max=16)
	private String card_number;
	
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
	
	@ManyToOne(optional=false)
	private OrderRequest payment;

}
