package com.gremio.agenda_web.controller;

import com.gremio.agenda_web.model.Evento;
import com.gremio.agenda_web.service.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agenda")
public class EventoController {

    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    @GetMapping
    public String verAgenda(Model model) {
        model.addAttribute("eventos", service.listarTodos());
        model.addAttribute("nuevoEvento", new Evento()); 
        return "agenda"; 
    }

    @PostMapping("/guardar")
    public String guardarEvento(@ModelAttribute Evento evento) {
        service.guardar(evento);
        return "redirect:/agenda";
    }

    @GetMapping("/editar/{id}")
    public String editarEvento(@PathVariable Long id, Model model) {
        model.addAttribute("nuevoEvento", service.buscarPorId(id)); 
        model.addAttribute("eventos", service.listarTodos()); 
        return "agenda"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/agenda";
    }
}