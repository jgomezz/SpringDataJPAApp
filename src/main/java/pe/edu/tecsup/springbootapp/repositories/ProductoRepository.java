package pe.edu.tecsup.springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.springbootapp.entities.Producto;

import java.util.List;

/**
 *
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByNombre(String nombre) throws Exception;

	/*
	List<Producto> findAll() throws Exception;

	List<Producto> findByName(String nombre) throws Exception;

	Producto findById(Long id) throws Exception;

	void save(Producto producto) throws Exception;
	
	void update(Long id, String nombreProducto) throws Exception;

	void deleteById(Long id) throws Exception;
	*/
}