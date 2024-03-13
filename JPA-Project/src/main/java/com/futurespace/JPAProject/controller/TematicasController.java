package com.futurespace.JPAProject.controller;

import com.futurespace.JPAProject.model.entity.Tematicas;
import com.futurespace.JPAProject.repository.ITematicasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tematicas")
public class TematicasController {

    @Autowired
    private ITematicasRepo tematicasRepository;

    @GetMapping
    public List<Tematicas> getAllTematicas() {
        return tematicasRepository.findAll();
    }

    @PostMapping
    public Tematicas createTematica(@RequestBody Tematicas tematica) {
        return tematicasRepository.save(tematica);
    }

    @PutMapping("/{id}")
    public Tematicas updateTematica(@PathVariable int id, @RequestBody Tematicas tematica) throws ChangeSetPersister.NotFoundException {
        if (tematicasRepository.existsById(id)) {
            tematica.setTematicaId(id);
            return tematicasRepository.save(tematica);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTematica(@PathVariable int id) {
        tematicasRepository.deleteById(id);
    }
}

