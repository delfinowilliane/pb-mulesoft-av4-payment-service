package br.com.paymentservicepb.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.paymentservicepb.dto.OrderRequestDto;
import br.com.paymentservicepb.service.OrderService;

@RestController
@RequestMapping("api/v1/order/payment")
public class OrderController {
	
	@Autowired
    private OrderService service;

    @GetMapping
    public Page<OrderRequestDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("api/v1/order/payment/{orderId}")
    public ResponseEntity<OrderRequestDto> detalhar(@PathVariable @NotNull Long id) {
    	OrderRequestDto dto = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<OrderRequestDto> cadastrar(@RequestBody @Valid OrderRequestDto dto, UriComponentsBuilder uriBuilder) {
    	OrderRequestDto payment = service.criarPagamento(dto);
        URI endereco = uriBuilder.path("api/v1/order/payment").buildAndExpand(payment.getId()).toUri();

        return ResponseEntity.created(endereco).body(payment);
    }

}