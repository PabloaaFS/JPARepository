package com.futurespace.JPAProject.controller;

import com.futurespace.JPAProject.model.entity.Libros;
import com.futurespace.JPAProject.repository.ILibrosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    private ILibrosRepo librosRepository;

    @GetMapping
    public List<Libros> getAllLibros() {
        return librosRepository.findAll();
    }

    @PostMapping
    public Libros createLibro(@RequestBody Libros libro) {
        return librosRepository.save(libro);
    }

    @PutMapping("/{isbn}")
    public Libros updateLibro(@PathVariable String isbn, @RequestBody Libros libro) throws ChangeSetPersister.NotFoundException {
        if (librosRepository.existsById(isbn)) {
            libro.setIsbn(isbn);
            return librosRepository.save(libro);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @DeleteMapping("/{isbn}")
    public void deleteLibro(@PathVariable String isbn) {
        librosRepository.deleteById(isbn);
    }

    @GetMapping("/hqllibros2001")
    public void LibrosPublicadosDespuesDe2001() {
        librosRepository.findLibrosPublicadosDespuesDe2001();
    }

    @GetMapping("/funcionlibros2001")
    public List<Libros> getLibrosPublicadosDespuesDe2001() { return ILibrosRepo.findByAnioPublicacionMayorQue(2001); }

    @GetMapping("/hqlisbn")
    public void IsbnBuscar() { ILibrosRepo.findLibroByIsbn("87919878"); }

    @GetMapping("/funcionisbn")
    public List<Libros> getIsbn() {
        return ILibrosRepo.findByIsbn("87919878");
    }

    @GetMapping("/hqleditorial")
    public void EditorialBuscar() {
        ILibrosRepo.findLibrosByEditorialNombre("RBA");
    }

    @GetMapping("/funcioneditorial")
    public List<Libros> getEditorial() {
        return ILibrosRepo.findByEditorialNombre("RBA");
    }


}

