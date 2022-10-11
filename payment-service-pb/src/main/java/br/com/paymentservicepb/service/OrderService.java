package br.com.paymentservicepb.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.paymentservicepb.dto.OrderRequestDto;
import br.com.paymentservicepb.model.OrderRequest;
import br.com.paymentservicepb.repository.OrderRepository;
import br.com.paymentservicepb.statics.Status;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
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
    	OrderRequest order_id = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(order_id, OrderRequestDto.class);
    }

    public OrderRequestDto criarPagamento(OrderRequestDto dto) {
    	OrderRequest order_id = modelMapper.map(dto, OrderRequest.class);
    	order_id.setStatus(Status.APPROVED);
        repository.save(order_id);

        return modelMapper.map(order_id, OrderRequestDto.class);
    }
}
