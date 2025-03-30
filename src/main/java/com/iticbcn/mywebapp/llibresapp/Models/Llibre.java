package com.iticbcn.mywebapp.llibresapp.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llibres")
public class Llibre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_llibre;
    @Column
    private String titol;
    @Column
    private String autor;
    @Column(length = 13)
    private String isbn;
    @Column
    private String editorial;
    @Column(name = "data_publicacio")
    private LocalDate datapublicacio;
    @Column
    private String tematica;

    public Llibre(String titol, String autor, String isbn, String editorial, LocalDate datapublicacio,
            String tematica) {
        this.titol = titol;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.datapublicacio = datapublicacio;
        this.tematica = tematica;
    }

    
}
