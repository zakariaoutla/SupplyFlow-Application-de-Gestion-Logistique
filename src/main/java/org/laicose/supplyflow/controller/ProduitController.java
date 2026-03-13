package org.laicose.supplyflow.controller;


import org.laicose.supplyflow.model.Produit;
import org.laicose.supplyflow.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;


    @GetMapping
    public List<Produit> getAll(){
        return produitService.getAllProduits();
    }
}
