package pe.edu.tecsup.springbootapp.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.tecsup.springbootapp.entities.Categoria;
import pe.edu.tecsup.springbootapp.entities.Producto;

@SpringBootTest
class ProductoServiceTest {

	private static Logger log 
		= LoggerFactory.getLogger(ProductoServiceTest.class);

	@Autowired
	private ProductoService productoService;
	

	@Test
	void testListar() {

		List<Producto> prods = null;

		try {
			prods = productoService.findAll();

			// stream
			prods.stream().forEach(item -> log.info(item.toString()));

		} catch (Exception e) {

			fail("Exception " + e.getMessage());

		}

		// Test validation..!
		assertThat(prods.isEmpty(), is(false));

	}

	@Test
	void testBuscarPorId() {

		Producto prod = null;
		Long ID_BUSCAR = 1L;
		String NOMBRE_ESPERADO = "Kingstone";
		String DESCRIPCION_ESPERADO = "Procesador Intel Core I7-8700 Lga 1151 8va";
		Double PRECIO_ESPERADO = 1479.99;
		
		try {
			prod = productoService.findById(ID_BUSCAR);
		} catch (Exception e) {
			fail("Exception " + e.getMessage());
		}

		// Test validation..!
		assertThat(prod.getNombre(), is(NOMBRE_ESPERADO));
		assertThat(prod.getDescripcion(), is(DESCRIPCION_ESPERADO));
		assertThat(prod.getPrecio(), is(PRECIO_ESPERADO));

	}	
	
	@Test
	void testfindByName() throws Exception {
		
		List<Producto> productos = productoService.findByNameLike("Intel");
		
		//log.info(">>>>" + productos.toString());
		productos.stream().forEach(item -> log.info(item.toString()));
		
		assertThat(productos.isEmpty(), is(true));
		//assertThat(cats.size(), is(3));
	}	

	@Test
	void testRegistrar() {

		Categoria categoria = new Categoria();
		categoria.setId(1L);
		
		Producto nuevoProducto = new Producto();
		nuevoProducto.setCategoria(categoria);
		nuevoProducto.setNombre("AMD");
		nuevoProducto.setDescripcion("AMD X10");
		nuevoProducto.setPrecio(280.0);
		nuevoProducto.setCreado(new Date());
		nuevoProducto.setStock(6);
		nuevoProducto.setEstado(1);
		

		try {

			List<Producto> productos = productoService.findAll();
			int totalAntes = productos.size();

			productoService.save(nuevoProducto);

			productos = productoService.findAll();
			int totalDespues = productos.size();

			assertThat(totalDespues - totalAntes, is(1));

		} catch (Exception e) {

			fail("Exception " + e.getMessage());

		}

	}

	@Test
	void testEliminar() {
		
		try {
		
			List<Producto> productos = productoService.findAll(); 
			
			int totalAntes = productos.size();
			
			if (productos.isEmpty()) {
				return; // test pass 
			}
			
			Producto ultimoProducto = productos.get(productos.size() - 1);
			
			productoService.deleteById(ultimoProducto.getId()); 
			
			// Lee nuevamente
			productos = productoService.findAll();
			
			int totalDespues = productos.size();
			
			// Validacion
			assertThat(totalAntes - totalDespues, is(1));
		
		} catch (Exception e) {

			fail("Exception " + e.getMessage());

		}		
	}

}
