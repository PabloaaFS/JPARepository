package com.futurespace.JPAProject.controller;

import com.futurespace.JPAProject.model.entity.Editoriales;
import com.futurespace.JPAProject.repository.IEditorialesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {

    @Autowired
    private IEditorialesRepo editorialesRepository;

    @GetMapping
    public List<Editoriales> getAllEditoriales() {
        return editorialesRepository.findAll();
    }

    @PostMapping
    public Editoriales createEditorial(@RequestBody Editoriales editorial) {
        return editorialesRepository.save(editorial);
    }

    @PutMapping("/{id}")
    public Editoriales updateEditorial(@PathVariable int id, @RequestBody Editoriales editorial) throws ChangeSetPersister.NotFoundException {
        if (editorialesRepository.existsById(id)) {
            editorial.setEditorialId(id);
            return editorialesRepository.save(editorial);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEditorial(@PathVariable int id) {
        editorialesRepository.deleteById(id);
    }
}

