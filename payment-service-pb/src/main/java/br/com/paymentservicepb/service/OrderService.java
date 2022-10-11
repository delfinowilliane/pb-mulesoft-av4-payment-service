package br.com.paymentservicepb.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.paymentservicepb.dto.OrderRequestDto;
import br.com.paymentservicepb.model.OrderRequest;
import br.com.paymentservicepb.repository.OrderRepository;
import br.com.paymentservicepb.statics.Status;

public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Page<OrderRequestDto> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, OrderRequestDto.class));
    }

    public OrderRequestDto obterPorId(Long id) {
    	OrderRequest order = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(order, OrderRequestDto.class);
    }

    public OrderRequestDto criarPagamento(OrderRequestDto dto) {
    	OrderRequest order = modelMapper.map(dto, OrderRequest.class);
        order.setStatus(Status.APPROVED);
        repository.save(order);

        return modelMapper.map(order, OrderRequestDto.class);
    }
}
