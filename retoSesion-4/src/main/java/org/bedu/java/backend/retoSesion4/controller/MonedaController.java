package org.bedu.java.backend.retoSesion4.controller;



import org.bedu.java.backend.retoSesion4.model.Moneda;
import org.bedu.java.backend.retoSesion4.service.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("monedas")
@Validated
public class MonedaController {

    private final MonedaService monedaService;

    @Autowired
    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<String> getMoneda() {
        return monedaService.getAll();
    }
    @GetMapping("/{moneda}")
    public List<String> getMoneda(@PathVariable("moneda") String moneda, double tipoCambio) {
        return monedaService.moneda(moneda);
    }
    @PostMapping("/moneda")
    public Moneda addMoneda(@RequestBody Moneda moneda) {
        return monedaService.agregar(moneda);
    }
    @PostMapping("/moneda/{id}")
    public Moneda remove(@RequestBody Moneda moneda) {
        return remove(moneda);
    }

}