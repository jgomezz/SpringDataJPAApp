package pe.edu.tecsup.springbootapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.tecsup.springbootapp.entities.Categoria;

@SpringBootTest
class CategoriaServiceTest {

	private static Logger log 
		= LoggerFactory.getLogger(CategoriaServiceTest.class);

	@Autowired
	CategoriaService categoriaService;
	
	
	@Test
	void testFindAll() throws Exception {
		
		List<Categoria> cats = null;
		
		try {
			
			cats = categoriaService.findAll();
			cats.stream().forEach(item -> log.info(item.toString()));
			
		} catch (Exception e) {
			
			fail("Exception " + e.getMessage());
		
		}

		// Test validation..!
		assertEquals(false , cats.isEmpty());

	}
	
}
