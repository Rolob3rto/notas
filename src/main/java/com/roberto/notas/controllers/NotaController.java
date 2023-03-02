package com.roberto.notas.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.roberto.notas.model.Nota;
import com.roberto.notas.services.NotaServices;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class NotaController {
    
    @Autowired
    NotaServices notaServices;

    @GetMapping("/notas")
    List<Nota> all(){
        return notaServices.findAll();
    }

    @GetMapping(value="/notas/buscar")
    public List<Nota> findByTitulo(@RequestParam() String titulo, @RequestParam() @DateTimeFormat(pattern = "dd/MM/yyyy")Date fecha) {
        
        List<Nota> notas = notaServices.findByTituloyFecha(titulo, fecha);
        return notas;
    }

    @GetMapping("/notas/{id}")
    Nota findNota(@PathVariable int id){
        return notaServices.findById(id);
    }

    @DeleteMapping("/notas/{id}")
    void deleteNota(@PathVariable int id){
        notaServices.delete(id);
    }

    @PostMapping("/notas")
    Nota guardar(@RequestBody Nota nota){
        notaServices.save(nota);

        return nota;
    }

    @PutMapping("/notas/{id}")
    void actualizar(@PathVariable int id, @RequestBody Nota nota){
        notaServices.update(id, nota);
    }

    
}
