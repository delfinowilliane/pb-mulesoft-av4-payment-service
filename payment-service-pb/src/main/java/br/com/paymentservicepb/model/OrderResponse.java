package br.com.paymentservicepb.model;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.paymentservicepb.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	
	private BigDecimal total;
	
	private String payment_id;
	
	private Status payment_status;
	
	private String message;

}
