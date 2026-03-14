package org.laicose.supplyflow.controller;


import org.laicose.supplyflow.model.Fournisseur;
import org.laicose.supplyflow.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;


    @GetMapping
    public List<Fournisseur> getAll(){
        return fournisseurService.getAllFournisseurs();
    }

    @GetMapping("/{id}")
    public Fournisseur getById(@PathVariable int id){
        return fournisseurService.getById(id);

    }

    @PostMapping
    public Fournisseur save(@RequestBody Fournisseur fournisseur){
        return fournisseurService.save(fournisseur);
    }

    @PutMapping("/{id}")
    public Fournisseur update(@PathVariable int id, @RequestBody Fournisseur fournisseur){
        return fournisseurService.update(id, fournisseur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        fournisseurService.delete(id);
    }

}
