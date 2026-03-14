package org.laicose.supplyflow.controller;


import org.laicose.supplyflow.model.Produit;
import org.laicose.supplyflow.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Produit getById(@PathVariable int id){
        return produitService.getById(id);
    }

    @PostMapping
    public Produit add(@RequestBody Produit product){
        return produitService.save(product);
    }

    @PutMapping("/{id}")
    public Produit update(@PathVariable int id, @RequestBody Produit produit){
        return produitService.update(id, produit);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        produitService.delete(id);
    }
}
