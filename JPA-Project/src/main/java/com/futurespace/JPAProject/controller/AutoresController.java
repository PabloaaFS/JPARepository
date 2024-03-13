package com.futurespace.JPAProject.controller;

import com.futurespace.JPAProject.model.entity.Autores;
import com.futurespace.JPAProject.repository.IAutoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    private IAutoresRepo autoresRepository;

    @GetMapping
    public List<Autores> getAllAutores() {
        return autoresRepository.findAll();
    }

    @PostMapping
    public Autores createAutor(@RequestBody Autores autor) {
        return autoresRepository.save(autor);
    }

    @PutMapping("/{id}")
    public Autores updateAutor(@PathVariable int id, @RequestBody Autores autor) throws ChangeSetPersister.NotFoundException {
        if (autoresRepository.existsById(id)) {
            autor.setAutorId(id);
            return autoresRepository.save(autor);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable int id) {
        autoresRepository.deleteById(id);
    }
}

