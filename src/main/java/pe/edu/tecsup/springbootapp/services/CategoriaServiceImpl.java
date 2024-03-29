package pe.edu.tecsup.springbootapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.springbootapp.entities.Categoria;
import pe.edu.tecsup.springbootapp.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private static Logger log 
		= LoggerFactory.getLogger(CategoriaServiceImpl.class);
	
	// Inyeccion de dependencias por constructor
	
	private final CategoriaRepository categoriaRepository;
	
	public CategoriaServiceImpl( CategoriaRepository x) {
		this.categoriaRepository = x;
	}
	
	
	@Override
	public List<Categoria> findAll() {

		log.info("calling services ....!") ;
		return categoriaRepository.findAll();

	}

	
}
