package org.laicose.supplyflow.service;


import org.laicose.supplyflow.model.MouvementStock;
import org.laicose.supplyflow.model.Produit;
import org.laicose.supplyflow.repository.MouvementStockRepository;
import org.laicose.supplyflow.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MouvementStockService {

    @Autowired
    private MouvementStockRepository mouvementStockRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public List<MouvementStock> getAll(){
        return mouvementStockRepository.findAll();
    }

    public MouvementStock save(MouvementStock mouvementStock) {
        if (mouvementStock.getProduit() != null && mouvementStock.getProduit().getId() != 0) {
            Produit produit = produitRepository.findById(mouvementStock.getProduit().getId()).orElse(null);
            mouvementStock.setProduit(produit);

            if (mouvementStock.getId() == 0) {
                if ("ENTREE".equals(mouvementStock.getType())) {
                    produit.setQuantite(produit.getQuantite() + mouvementStock.getQuantite());
                } else if ("SORTIE".equals(mouvementStock.getType())) {
                    produit.setQuantite(produit.getQuantite() - mouvementStock.getQuantite());
                }
                produitRepository.save(produit);
            }
        }

        if (mouvementStock.getDate() == null) {
            mouvementStock.setDate(LocalDate.now());
        }

        return mouvementStockRepository.save(mouvementStock);
    }



}
