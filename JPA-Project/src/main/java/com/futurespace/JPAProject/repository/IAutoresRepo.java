package com.futurespace.JPAProject.repository;

import com.futurespace.JPAProject.model.entity.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAutoresRepo extends JpaRepository<Autores, Integer> {
}

