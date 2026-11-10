package com.gremio.agenda_web.controller;

import com.gremio.agenda_web.model.Evento;
import com.gremio.agenda_web.repository.EventoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agenda")
public class EventoController {
    private EventoRepository eventoRepository;

    public EventoController(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    // Muestra la página de la agenda con la lista y el formulario
    @GetMapping
    public String verAgenda(Model model) {
        model.addAttribute("eventos", eventoRepository.findAll());
        model.addAttribute("nuevoEvento", new Evento()); // Objeto vacío para el form
        return "agenda"; 
    }

    // Guarda el evento y recarga la página
    @PostMapping("/guardar")
    public String guardarEvento(@ModelAttribute Evento evento) {
        eventoRepository.save(evento);
        return "redirect:/agenda";
    }

    // Elimina un evento por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        eventoRepository.deleteById(id);
        return "redirect:/agenda";
    }

    // Editar un evento existente
    @GetMapping("/editar/{id}")
    public String editarEvento(@PathVariable Long id, Model model) {
        // Buscamos el evento, si existe lo mandamos al formulario
        Evento evento = eventoRepository.findById(id).orElse(new Evento());
        model.addAttribute("nuevoEvento", evento); 
        model.addAttribute("eventos", eventoRepository.findAll()); // Cargamos la tabla también
        return "agenda"; 
    }
}
