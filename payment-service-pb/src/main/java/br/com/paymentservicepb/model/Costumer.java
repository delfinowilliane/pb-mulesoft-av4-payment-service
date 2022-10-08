package br.com.paymentservicepb.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Costumer {
	@NotNull @Enumerated(EnumType.STRING)
	private DocumentType document_type;
	
	@NotNull @Size(min=11, max=14)
	private Integer document_number;
}
