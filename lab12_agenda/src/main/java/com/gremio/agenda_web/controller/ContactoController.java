package com.gremio.agenda_web.controller;

import com.gremio.agenda_web.model.Contacto;
import com.gremio.agenda_web.repository.ContactoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContactoController {

    private final ContactoRepository repo;

    public ContactoController(ContactoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", repo.findAll());
        return "contactos";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        repo.save(contacto);
        return "redirect:/contactos";
    }

    @GetMapping("/eliminar/{id}")
public String eliminar(@PathVariable Long id) {
    repo.deleteById(id);
    return "redirect:/contactos";
}

@GetMapping("/editar/{id}")
public String editar(@PathVariable Long id, Model model) {
    Contacto contacto = repo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(
                    "Contacto no encontrado: " + id));

    model.addAttribute("contacto", contacto);
    return "editar";
}

@PostMapping("/actualizar/{id}")
public String actualizar(@PathVariable Long id,
                         @ModelAttribute Contacto contacto) {
    contacto.setId(id);
    repo.save(contacto);
    return "redirect:/contactos";
}
}