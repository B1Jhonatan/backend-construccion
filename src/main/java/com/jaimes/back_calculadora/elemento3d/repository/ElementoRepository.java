package com.jaimes.back_calculadora.elemento3d.repository;

import com.jaimes.back_calculadora.general.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementoRepository extends JpaRepository<Tipo, Integer> {
}
