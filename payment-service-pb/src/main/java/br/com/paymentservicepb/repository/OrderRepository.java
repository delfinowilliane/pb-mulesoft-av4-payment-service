package br.com.paymentservicepb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paymentservicepb.model.OrderRequest;

public interface OrderRepository extends JpaRepository<OrderRequest, Long>{
	
}