package com.futurespace.JPAProject.repository;

import com.futurespace.JPAProject.model.entity.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILibrosRepo extends JpaRepository<Libros, String> {


    /**
     * Mostrar los libros publicados en el año 2001.
     * @return
     */

    // HQL
    @Query(value = "SELECT l FROM Libros l WHERE l.anioPublicacion > 2001")
    List<Libros> findLibrosPublicadosDespuesDe2001();


    // FUNCION
    static List<Libros> findByAnioPublicacionMayorQue(int anioPublicacion) { return null; }

    /**
     * Mostrar el libro cuyo ISBN es el 87919878.
     *
     * @param isbn
     * @return
     */

    // HQL
    @Query("SELECT l FROM Libros l WHERE l.isbn = ?1")
    static List<Libros> findLibroByIsbn(String isbn) {
        return null;
    }

    // FUNCION
    static List<Libros> findByIsbn(String isbn) {
        return null;
    }

    /**
     * Mostrar los libros de la editorial RBA.
     *
     * @param nombreEditorial
     * @return
     */

    // HQL
    @Query("SELECT l FROM Libros l WHERE l.editorial = ?1")
    static List<Libros> findLibrosByEditorialNombre(String nombreEditorial) {
        return null;
    }

    // FUNCION
    static List<Libros> findByEditorialNombre(String nombreEditorial) {
        return null;
    }

}

