package com.supplyflow.service;


import com.supplyflow.model.Produit;
import com.supplyflow.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

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

    public void delete(int id){
        produitRepository.deleteById(id);
    }
}
