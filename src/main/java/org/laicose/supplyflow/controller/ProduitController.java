package org.laicose.supplyflow.controller;


import org.laicose.supplyflow.model.Produit;
import org.laicose.supplyflow.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;


    @GetMapping
    public String getAll(Model model){
        model.addAttribute("produits", produitService.getAllProduits());
        return "produits/list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model){
        model.addAttribute("produits", produitService.getById(id));
        return "produits/detail";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("produit", new Produit());
        return "produits/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Produit produit) {
        produitService.save(produit);
        return "redirect:/produits";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("produit", produitService.getById(id));
        return "produits/form";
    }

    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable int id){
        produitService.delete(id);
        return "redirect:/produits";
    }
}
