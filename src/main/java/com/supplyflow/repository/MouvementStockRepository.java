package com.supplyflow.repository;

import com.supplyflow.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Integer> {

}
