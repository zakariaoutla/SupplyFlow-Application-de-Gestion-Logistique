package org.laicose.supplyflow.controller;


import org.aspectj.apache.bcel.classfile.Module;
import org.laicose.supplyflow.model.Fournisseur;
import org.laicose.supplyflow.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;


    @GetMapping
    public String getAll(Model model){
        model.addAttribute("fournisseurs", fournisseurService.getAllFournisseurs());
        return "fournisseur/list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model){
        model.addAttribute("fournisseurs", fournisseurService.getById(id));
        return "fournisseurs/detail";

    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("fournisseur", new Fournisseur());
        return "fournisseur/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Fournisseur fournisseur){
        fournisseurService.save(fournisseur);
        return "redirect:/fournisseur";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable int id, Model model){
        model.addAttribute("fournisseur", fournisseurService.getById(id));
        return "fournisseur/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        fournisseurService.delete(id);
        return "redirect:/fournisseur";
    }

}
