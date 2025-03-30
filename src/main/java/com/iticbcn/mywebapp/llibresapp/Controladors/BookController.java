package com.iticbcn.mywebapp.llibresapp.Controladors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.iticbcn.mywebapp.llibresapp.Models.Llibre;

import com.iticbcn.mywebapp.llibresapp.Serveis.LlibreServei;


@Controller
@SessionAttributes("users")
public class BookController {

    @Autowired //Injecta dependències al controllador
    LlibreServei llibreServei;

    @GetMapping("/") //retorna una vista al localhost
    public String iniciar(Model model) {
        return "login";
    }

    @PostMapping("/index")
    public String login(@RequestParam String usuari, @RequestParam String password, Model model) {


        if (usuari.equals("toni") 
        && password.equals("h3ll0!!")) {
            return "index";
        } else {
            return "login";
        }        
    }




    @PostMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }



    //@RequestParam tiene que asegurar de ser usuario y contraseña para depsues llevar a la otra pagina
        @GetMapping("/index")
    public String index(Model model) {

            return "index";
        
    }

    @GetMapping("/consulta") 
    public String consulta(Model model) {

        Set<Llibre> llibres = llibreServei.findAll();

        model.addAttribute("llibres", llibres);
        
        return "consulta";
    }

    @GetMapping("/inserir") 
    public String inputInserir(Model model) {
        
        return "inserir";
    }

    @PostMapping("/inserir")
    public String inserir(
                          @RequestParam(name = "titol") String titol,  
                          @RequestParam(name = "autor") String autor,
                          @RequestParam(name = "isbn") String isbn,
                          @RequestParam(name = "editorial") String editorial,  
                          @RequestParam(name = "datapublicacio") String datapublicacioString,
                          @RequestParam(name = "tematica") String tematica,
                          Model model) {

        
        LocalDate datapublicacio = LocalDate.parse(datapublicacioString);

        Llibre llibre = new Llibre(titol, autor, isbn, editorial, datapublicacio, tematica);
        llibreServei.addLlibre(llibre);

    

        model.addAttribute("llibres", llibreServei.findAll());

        return "consulta";            
        

    }
        @GetMapping("/cercaid")
    public String inputCerca(Model model) {

        Llibre llibre = new Llibre();
        llibre.setId_llibre(0);
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        model.addAttribute("llibre", llibre);

        return "cercaid";

    }

    @PostMapping("/cercaid")
    public String cercaId(
                          @RequestParam(name = "idLlibre", required = false) String idLlibre, 
                          Model model) {
        
        Long idLlib = 0l;
        String message = "";
        boolean llibreErr = false;

        try {
            idLlib = Long.parseLong(idLlibre);
            Optional<Llibre> llibre = llibreServei.findByIdLlibre(idLlib);
            if(llibre.isPresent()) {
                model.addAttribute("llibre", llibre.get());
            } else {
                message = "No hi ha cap llibre amb aquesta id";
                llibreErr = true;
            }

        } catch (Exception e) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
        } 
        
        model.addAttribute("message", message);
        model.addAttribute("llibreErr",llibreErr);

        return "cercaid";

    }







}
