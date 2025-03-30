package com.iticbcn.mywebapp.llibresapp.Serveis;

import java.util.Optional;
import java.util.Set;



import com.iticbcn.mywebapp.llibresapp.Models.Llibre;

public interface LlibreServei {

    Set<Llibre> findAll();
    Llibre findByTitol(String titol);
    Set<Llibre> findByTitolAndEditorial(String titol, String editorial);
    boolean validateISBN(String isbn);
    Optional<Llibre> findByIdLlibre(Long id);
    void addLlibre(Llibre llibre);
    
}
