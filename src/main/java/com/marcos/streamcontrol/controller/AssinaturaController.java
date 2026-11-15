package com.marcos.streamcontrol.controller;

import com.marcos.streamcontrol.entity.Assinatura;
import com.marcos.streamcontrol.service.AssinaturaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assinaturas")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("assinaturas", assinaturaService.listar());
        model.addAttribute("total", assinaturaService.totalMensal());
        return "assinaturas/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("assinatura", new Assinatura());
        return "assinaturas/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Assinatura assinatura, BindingResult result) {
        if (result.hasErrors()) {
            return "assinaturas/formulario";
        }
        assinaturaService.salvar(assinatura);
        return "redirect:/assinaturas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("assinatura", assinaturaService.buscarPorId(id));
        return "assinaturas/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        assinaturaService.excluir(id);
        return "redirect:/assinaturas";
    }
}