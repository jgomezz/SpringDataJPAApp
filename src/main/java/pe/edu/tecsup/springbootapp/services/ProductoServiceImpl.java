package pe.edu.tecsup.springbootapp.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.springbootapp.entities.Producto;
import pe.edu.tecsup.springbootapp.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	private static Logger log 
		= LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> findAll() throws Exception {

		log.info("calling services ....!") ;
		
		return productoRepository.findAll();

	}

	@Override
	public Producto findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		log.info("call findById(id: " + id + ")");
		
		Optional<Producto> optionalProd 
			= productoRepository.findById(id);
		
		if ( optionalProd.isPresent())
			return optionalProd.get();
		else
			throw new Exception("Not found record...!");
	}  

	@Override
	public Producto save(Producto producto) throws Exception {

		return productoRepository.save(producto);
	
	}

	@Override
	public void deleteById(Long id) throws Exception {

		productoRepository.deleteById(id);
	
	}

	@Override
	public List<Producto> findByNameLike(String nombre) {
		
		return productoRepository.findByNameLike(nombre);
		
	}

	
}
