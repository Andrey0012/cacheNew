package com.example.cachenew.controller;


import com.example.cachenew.entity.Element;
import com.example.cachenew.service.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ElementController {

    private final ElementService elementService;

    @GetMapping("/{id}")
    public Element getElement(@PathVariable int id) {
        return elementService.getElement(id);
    }

    @PostMapping("/")
    public Integer addUpdateElement(@RequestBody Element element) {
        return elementService.saveElement(element).getId();
    }
}
