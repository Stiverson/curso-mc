package com.stiverson.projeto.cursomc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stiverson.projeto.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria ,Integer> {

}
