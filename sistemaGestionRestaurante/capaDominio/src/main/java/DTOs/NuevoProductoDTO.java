package DTOs;

import enums.EstadoProducto;
import enums.TipoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Clase DTO utilizada para registrar un nuevo producto en el sistema.
 * Contiene información básica del producto, su estado, tipo, precio
 * y los ingredientes necesarios para su preparación.
 */
public class NuevoProductoDTO {

    /** Estado actual del producto (ej. disponible, agotado) */
    private EstadoProducto estado;

    /** Nombre del producto */
    private String nombre;

    /** Precio del producto */
    private double precio;

    /** Tipo o categoría del producto */
    private TipoProducto tipoProducto;

    /** Lista de ingredientes asociados al producto */
    private List<IngredienteProductoDTO> ingredientesProductos;

    /**
     * Constructor para inicializar los datos de un nuevo producto.
     *
     * @param estado Estado actual del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param tipoProducto Tipo o categoría del producto
     * @param ingredientesProductos Lista de ingredientes requeridos
     */
    public NuevoProductoDTO(EstadoProducto estado, String nombre, double precio, TipoProducto tipoProducto, List<IngredienteProductoDTO> ingredientesProductos) {
        this.estado = estado;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.ingredientesProductos = ingredientesProductos;
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
     * Obtiene el nombre del producto.
     *
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
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
     * Obtiene el tipo o categoría del producto.
     *
     * @return Tipo de producto
     */
    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Obtiene la lista de ingredientes requeridos para el producto.
     *
     * @return Lista de ingredientes
     */
    public List<IngredienteProductoDTO> getIngredientesProductos() {
        return ingredientesProductos;
    }
}