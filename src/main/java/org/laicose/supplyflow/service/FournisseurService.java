package org.laicose.supplyflow.service;


import org.laicose.supplyflow.model.Fournisseur;
import org.laicose.supplyflow.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;


    public List<Fournisseur> getAllFournisseurs(){
        return fournisseurRepository.findAll();
    }

    public Fournisseur getById(int id){
        return fournisseurRepository.findById(id).orElse(null);
    }

    public Fournisseur save(Fournisseur fournisseurs){
        return fournisseurRepository.save(fournisseurs);
    }

    public Fournisseur update(int id, Fournisseur newData){
        Fournisseur fournisseurs = fournisseurRepository.findById(id).orElse(null);
        if (fournisseurs == null) return null;

        fournisseurs.setNom(newData.getNom());
        fournisseurs.setTelephone(newData.getTelephone());
        fournisseurs.setVille(newData.getVille());

        return fournisseurRepository.save(fournisseurs);

    }

    public void delete(int id){
        fournisseurRepository.deleteById(id);
    }
}
