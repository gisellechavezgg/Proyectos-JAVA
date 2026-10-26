package com.gremio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.gremio.model.Aventurero; // Importante para usar la clase

@Controller
public class SaludoController {

    @GetMapping("/saludo")
    public String saludo(Model model) {
        String mensaje = "¡Hola Mundo desde Spring Boot!";
        String gremio = "Gran Gremio de Aventureros";
        int nivel = 1;

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("gremio", gremio);
        model.addAttribute("nivel", nivel);

        return "saludo";
    }

    // NUEVO MÉTODO PARA LA PARTE 6
    @GetMapping("/aventurero")
    public String aventurero(Model model) {
        Aventurero a = new Aventurero("Sylva", "Druida", 10);
        model.addAttribute("aventurero", a);
        
        return "aventurero"; // Busca templates/aventurero.html
    }
}