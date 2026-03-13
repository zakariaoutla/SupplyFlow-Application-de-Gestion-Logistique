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

    public MouvementStock entree(int id, int quantite){
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit == null) return null;

        produit.setQuantite(produit.getQuantite()+ quantite);
        produitRepository.save(produit);

        MouvementStock mouvement = new MouvementStock();
        mouvement.setProduit(produit);
        mouvement.setQuantite(quantite);
        mouvement.setType("Entree");
        mouvement.setDate(LocalDate.now());

        return mouvementStockRepository.save(mouvement);


    }

    public MouvementStock sortie(int id, int quantite){
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit == null) return null;
        if (produit.getQuantite()< quantite){
            return null;
        }

        produit.setQuantite(produit.getQuantite() - quantite);
        produitRepository.save(produit);

        MouvementStock mouvementStock = new MouvementStock();

        mouvementStock.setProduit(produit);
        mouvementStock.setQuantite(quantite);
        mouvementStock.setType("Sortie");
        mouvementStock.setDate(LocalDate.now());

        return mouvementStockRepository.save(mouvementStock);
    }



}
