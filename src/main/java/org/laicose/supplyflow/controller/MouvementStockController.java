package org.laicose.supplyflow.controller;


import org.laicose.supplyflow.model.MouvementStock;
import org.laicose.supplyflow.service.MouvementStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class MouvementStockController {

    @Autowired
    private MouvementStockService mouvementStockService;

    @GetMapping
    public List<MouvementStock> getAll(){
        return mouvementStockService.getAll();
    }

    @PostMapping("/entre")
    public MouvementStock entre(@RequestParam int id, @RequestParam int quantite){
        return mouvementStockService.entree(id, quantite);
    }

    @PostMapping("/sortie")
    public MouvementStock sortie(@RequestParam int id, @RequestParam int quantite){
        return mouvementStockService.sortie(id, quantite);
    }



}
