package org.laicose.supplyflow.repository;

import org.laicose.supplyflow.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
