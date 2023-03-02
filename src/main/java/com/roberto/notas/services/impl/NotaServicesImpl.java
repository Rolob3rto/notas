package com.roberto.notas.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.notas.model.Nota;
import com.roberto.notas.repository.NotaRepository;
import com.roberto.notas.services.NotaServices;

@Service
public class NotaServicesImpl implements NotaServices {
    
    @Autowired
    NotaRepository notaRepository;

    public List<Nota> findAll(){
        return notaRepository.findAll();
    }

    public Nota findById(int id){
        Optional<Nota> findById = notaRepository.findById(id);
        if(findById != null){
            return findById.get();
        } 
        return null;    
    }

    public void save(Nota nota){
        notaRepository.save(nota);
    }

    public void update(int id,Nota nota){
        this.findById(id);
        nota.setId(id);
        notaRepository.save(nota);
    }

    public void delete(int id){
        notaRepository.deleteById(id);
    }

    @Override
    public List<Nota> findByTituloyFecha(String titulo, Date fecha) {        
        return notaRepository.findByTituloContainingAndFechaGreaterThan(titulo, fecha);
    }
}
