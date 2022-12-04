package pe.edu.tecsup.springbootapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public String getImagen_nombre() {
		return imagen_nombre;
	}

	public void setImagen_nombre(String imagen_nombre) {
		this.imagen_nombre = imagen_nombre;
	}

	public String getImagen_tipo() {
		return imagen_tipo;
	}

	public void setImagen_tipo(String imagen_tipo) {
		this.imagen_tipo = imagen_tipo;
	}

	public Long getImagen_tamanio() {
		return imagen_tamanio;
	}

	public void setImagen_tamanio(Long imagen_tamanio) {
		this.imagen_tamanio = imagen_tamanio;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", stock=" + stock + ", imagen_nombre=" + imagen_nombre + ", imagen_tipo=" + imagen_tipo
				+ ", imagen_tamanio=" + imagen_tamanio + ", estado=" + estado + ", creado=" + creado + "]";
	}


	

}
