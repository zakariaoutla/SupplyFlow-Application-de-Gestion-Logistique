package org.laicose.supplyflow.service;


import jakarta.transaction.Transactional;
import org.laicose.supplyflow.model.Produit;
import org.laicose.supplyflow.repository.MouvementStockRepository;
import org.laicose.supplyflow.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private MouvementStockRepository mouvementStockRepository;

    public List<Produit> getAllProduits(){
        return produitRepository.findAll();
    }

    public Produit getById(int id){
        return produitRepository.findById(id).orElse(null);
    }

    public Produit save(Produit produits){
        return produitRepository.save(produits);
    }

    public Produit update(int id, Produit newData){
        Produit produits = produitRepository.findById(id).orElse(null);
        if(produits == null) return null;

        produits.setNom(newData.getNom());
        produits.setCategorie(newData.getCategorie());
        produits.setPrix(newData.getPrix());
        produits.setQuantite(newData.getQuantite());

        return produitRepository.save(produits);

    }


    @Transactional
    public void delete(int id){
        mouvementStockRepository.deleteByProduitId(id);
        produitRepository.deleteById(id);
    }
}
