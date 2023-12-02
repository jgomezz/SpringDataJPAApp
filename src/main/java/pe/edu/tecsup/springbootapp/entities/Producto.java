package pe.edu.tecsup.springbootapp.entities;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String descripcion;

	private Double precio;

	private Integer stock;

	private String imagen_nombre;

	private String imagen_tipo;

	private Long imagen_tamanio;

	private Integer estado;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creado;
	
	@ManyToOne
	@JoinColumn(name="categorias_id") // FK
	private Categoria categoria;

	
}
