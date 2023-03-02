package com.roberto.notas.services;

import java.util.Date;
import java.util.List;

import com.roberto.notas.model.Nota;

public interface NotaServices {
    
    public List<Nota> findAll();

    public Nota findById(int id);

    public void save(Nota nota);

    public void update(int id, Nota nota);

    public void delete(int id);

    public List<Nota> findByTituloyFecha(String titulo, Date fecha);
}
