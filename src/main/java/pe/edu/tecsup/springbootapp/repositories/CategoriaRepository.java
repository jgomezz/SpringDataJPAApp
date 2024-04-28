package pe.edu.tecsup.springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.tecsup.springbootapp.entities.Categoria;
import pe.edu.tecsup.springbootapp.entities.Producto;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    //@Query("SELECT c FROM Categoria c WHERE c.nombre = :name")
    //List<Categoria> findByNombre(@Param("name") String name);

    List<Categoria> findByNombre(String nombre) throws Exception;

}
