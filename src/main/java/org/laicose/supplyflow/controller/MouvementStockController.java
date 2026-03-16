package org.laicose.supplyflow.controller;


import org.laicose.supplyflow.model.MouvementStock;
import org.laicose.supplyflow.service.MouvementStockService;
import org.laicose.supplyflow.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mouvementstock")
public class MouvementStockController {

    @Autowired
    private MouvementStockService mouvementStockService;

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("mouvementstock", mouvementStockService.getAll());
        return "mouvementstock/list";
    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("mouvementstock", new MouvementStock());
        model.addAttribute("produits", produitService.getAllProduits());
        return "mouvementstock/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MouvementStock mouvementstock) {
        mouvementStockService.save(mouvementstock);
        return "redirect:/mouvementstock";
    }
}
