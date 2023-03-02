package com.roberto.notas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roberto.notas.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
    public List<Nota> findByTituloContainingAndFechaGreaterThan(String titulo, Date fecha);
}
