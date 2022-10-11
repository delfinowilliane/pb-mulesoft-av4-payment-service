package br.com.paymentservicepb.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Items {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank @Size(max=25)
	private String item;
	
	@NotNull @Positive
	private BigDecimal value;
	
	@NotNull @Positive
	private Integer qty;
	
	@ManyToOne(optional=false)
	private OrderRequest itemsInfo;

}
