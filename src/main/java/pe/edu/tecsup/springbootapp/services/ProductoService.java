package pe.edu.tecsup.springbootapp.services;

import java.util.List;

import pe.edu.tecsup.springbootapp.entities.Producto;

public interface ProductoService {

	List<Producto> findAll();

	List<Producto> findByNameLike(String nombre);

	Producto findById(Long id);

	Producto save(Producto producto);

	void deleteById(Long id);

}
