package br.com.paymentservicepb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.paymentservicepb.statics.Currency;
import br.com.paymentservicepb.statics.DocumentType;
import br.com.paymentservicepb.statics.PaymentType;
import br.com.paymentservicepb.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @Enumerated(EnumType.STRING)
	private DocumentType document_type;
		
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="itemsInfo")
    private List<Items> items = new ArrayList<>();
    
	@NotNull @Positive
    private BigDecimal shipping;
	
	@NotNull @Positive
    private BigDecimal discount;
    
    @NotNull @Enumerated(EnumType.STRING)
	private PaymentType payment_type;
	
	@NotNull @Enumerated(EnumType.STRING)
	private Currency currency_type;
			
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="payment")
    private List<Card> payment = new ArrayList<>();
    
    private Status status;
}
