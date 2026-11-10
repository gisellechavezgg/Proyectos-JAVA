package com.gremio.agenda_web.controller;

import com.gremio.agenda_web.model.Danzante;
import com.gremio.agenda_web.service.DanzanteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DanzanteController {

    private final DanzanteService service;

    public DanzanteController(DanzanteService service) {
        this.service = service;
    }

    @GetMapping("/danzantes")
    public String listar(Model model) {
        model.addAttribute("danzantes", service.listarTodos());
        return "danzantes";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("danzante", new Danzante());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Danzante danzante) {
        service.guardar(danzante);
        return "redirect:/danzantes";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("danzante", service.buscarPorId(id));
        return "formulario";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Danzante danzante) {
        service.guardar(danzante);
        return "redirect:/danzantes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/danzantes";
    }
}
