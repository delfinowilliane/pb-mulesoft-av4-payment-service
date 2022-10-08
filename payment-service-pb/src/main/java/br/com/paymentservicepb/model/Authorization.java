package br.com.paymentservicepb.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authorization {
	private String authorization_code;
	private LocalDateTime authorized_at=LocalDateTime.now();
	private String reason_code;	
	private String reason_message;
}
