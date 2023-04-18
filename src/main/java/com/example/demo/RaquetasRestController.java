package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RaquetasRestController {
    private Integer id, uuid;
    private String marca, modelo;
    private Float precio;
    //Necesito guardar una imagen , que ya veré cómo hacerlo.
    //File imagen;
    private Date fechaDeCreacion, fechaDeActualizacion;
    private final RaquetasRepository raquetasRepository;

    @Autowired
    public RaquetasRestController(RaquetasRepository raquetasRepository) {
        this.raquetasRepository = raquetasRepository;
    }

    @GetMapping("/raquetas")
    public ResponseEntity<List<Raqueta>> getRaquetas() {
        return ResponseEntity.ok(raquetasRepository.findAll());
    }

    @GetMapping("/raquetas/{id}")
    public ResponseEntity<Raqueta> getRaqueta(@PathVariable Long id) {
        return ResponseEntity.ok(raquetasRepository.findById(id).get());
    }

    @PostMapping("/raquetas")
    public ResponseEntity<Raqueta> createRaqueta(@RequestBody Raqueta raqueta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(raquetasRepository.save(raqueta));
    }

    @PutMapping("/raquetas/{id}")
    public ResponseEntity<Raquetas> updateRaqueta(@PathVariable Long id, @RequestBody Raqueta raqueta) {
        return ResponseEntity.ok(raquetasRepository.save(raqueta));
    }
}
