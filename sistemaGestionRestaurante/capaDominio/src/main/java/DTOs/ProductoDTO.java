package DTOs;

import entidades.IngredienteProducto;
import enums.EstadoProducto;
import enums.TipoProducto;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Clase DTO que representa un producto registrado en el sistema,
 * incluyendo su identificador, nombre, precio, tipo, estado e ingredientes asociados.
 */
public class ProductoDTO {

    /** Identificador único del producto */
    private Long id;

    /** Nombre del producto */
    private String nombre;

    /** Precio del producto */
    private double precio;

    /** Tipo o categoría del producto */
    private TipoProducto tipo;

    /** Lista de ingredientes que componen el producto */
    private List<IngredienteProductoDTO> ingredientes;

    /** Estado actual del producto (ej. disponible, agotado) */
    private EstadoProducto estado;

    /**
     * Constructor para inicializar todos los campos del producto.
     *
     * @param id Identificador del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param tipo Tipo o categoría del producto
     * @param estado Estado actual del producto
     * @param ingredientes Lista de ingredientes asociados al producto
     */
    public ProductoDTO(Long id, String nombre, double precio, TipoProducto tipo, EstadoProducto estado, List<IngredienteProductoDTO> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
        this.ingredientes = ingredientes;
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return ID del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del producto.
     *
     * @param id Nuevo ID del producto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Nuevo precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el tipo del producto.
     *
     * @return Tipo de producto
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del producto.
     *
     * @param tipo Nuevo tipo
     */
    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la lista de ingredientes del producto.
     *
     * @return Lista de ingredientes
     */
    public List<IngredienteProductoDTO> getIngredientes() {
        return ingredientes;
    }

    /**
     * Establece la lista de ingredientes del producto.
     *
     * @param ingredientes Nuevos ingredientes
     */
    public void setIngredientes(List<IngredienteProductoDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Obtiene el estado actual del producto.
     *
     * @return Estado del producto
     */
    public EstadoProducto getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del producto.
     *
     * @param estado Nuevo estado del producto
     */
    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }
}