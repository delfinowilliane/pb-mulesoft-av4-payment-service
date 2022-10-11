package br.com.paymentservicepb.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.CurrencyType;

import br.com.paymentservicepb.statics.DocumentType;
import br.com.paymentservicepb.statics.PaymentType;
import br.com.paymentservicepb.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
	
	private Long id;
	private DocumentType document_type;
    private List<ItemsDto> items_id = new ArrayList<>();
    private BigDecimal shipping;
	private BigDecimal discount;
	private PaymentType payment_type;
	private CurrencyType currency_type;
    private List<CardDto> payment_id = new ArrayList<>();
    private Status status;

}
