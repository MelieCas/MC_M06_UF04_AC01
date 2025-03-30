package com.iticbcn.mywebapp.llibresapp.Serveis;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.mywebapp.llibresapp.Models.Llibre;
import com.iticbcn.mywebapp.llibresapp.Repositoris.LlibreRepositori;

@Service
public class LlibreServeiImpl implements LlibreServei {
    @Autowired
    private LlibreRepositori llibreRepositori;

    @Override
    public Set<Llibre> findAll() {
        return llibreRepositori.findAll();
    }

    @Override
    public Llibre findByTitol(String titol) {
        return llibreRepositori.findByTitol(titol);
    }

    @Override
    public Set<Llibre> findByTitolAndEditorial(String titol, String editorial) {
        return llibreRepositori.findByTitolAndEditorial(titol, editorial);
    }

    @Override
    public boolean validateISBN(String isbn) {
        if (isbn.length() != 13) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Llibre> findByIdLlibre(Long id) {
        return llibreRepositori.findById(id);
    }

    @Override
    public void addLlibre(Llibre llibre) {
        llibreRepositori.save(llibre);
    }
}
