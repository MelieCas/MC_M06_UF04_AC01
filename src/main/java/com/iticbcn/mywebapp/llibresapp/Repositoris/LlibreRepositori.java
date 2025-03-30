package com.iticbcn.mywebapp.llibresapp.Repositoris;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.iticbcn.mywebapp.llibresapp.Models.Llibre;

public interface LlibreRepositori extends CrudRepository<Llibre, Long> {
    @Override
    @NonNull
    Set<Llibre> findAll();
    Llibre findByTitol(String titol);
    Set<Llibre> findByTitolAndEditorial(String titol, String editorial);
    
}
