package br.com.paymentservicepb.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Costumer costumer;
	
	@NotNull @Enumerated(EnumType.STRING)
	private PaymentType payment_type;
	
	@NotNull @Enumerated(EnumType.STRING)
	private Currency currency;
	
    @NotNull @Positive
	private BigDecimal transaction_amount;
	
    @NotNull
	private Card card;
    
    @NotNull @Enumerated(EnumType.STRING)
    private Status status;
    
    private LocalDateTime received_at = LocalDateTime.now();
    
    private Authorization authorization;
}
