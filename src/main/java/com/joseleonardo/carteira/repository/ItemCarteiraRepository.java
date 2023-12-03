package com.joseleonardo.carteira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseleonardo.carteira.entity.ItemCarteira;

@Repository
public interface ItemCarteiraRepository extends JpaRepository<ItemCarteira, Long> {

}
