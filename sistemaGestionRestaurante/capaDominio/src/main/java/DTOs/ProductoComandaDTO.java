package DTOs;

import entidades.Producto;

/**
 *
 * @author janot
 */
/**
 * Clase DTO que representa un producto dentro de una comanda,
 * incluyendo información como el precio aplicado, cantidad, comentario e importe total.
 */
public class ProductoComandaDTO {

    /** Identificador único del producto dentro de la comanda */
    private Long id;

    /** Producto seleccionado */
    private Producto producto;

    /** Precio actual del producto al momento de generar la comanda */
    private double precioActual;

    /** Comentario adicional del cliente sobre el producto (opcional) */
    private String comentario;

    /** Cantidad solicitada del producto */
    private Integer cantidad;

    /** Importe total por este producto (precioActual * cantidad) */
    private double importe;

    /**
     * Constructor para inicializar un producto dentro de una comanda.
     *
     * @param producto Producto seleccionado
     * @param precioActual Precio aplicado al producto
     * @param comentario Comentario del cliente (puede ser null)
     * @param cantidad Cantidad del producto solicitada
     * @param importe Importe total por el producto
     */
    public ProductoComandaDTO(Producto producto, double precioActual, String comentario, Integer cantidad, double importe) {
        this.producto = producto;
        this.precioActual = precioActual;
        this.comentario = comentario;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    /**
     * Obtiene el producto asociado.
     *
     * @return Producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Obtiene el precio aplicado al producto.
     *
     * @return Precio actual
     */
    public double getPrecioActual() {
        return precioActual;
    }

    /**
     * Obtiene el comentario del cliente sobre el producto.
     *
     * @return Comentario (puede ser null)
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Obtiene la cantidad del producto solicitada.
     *
     * @return Cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Obtiene el importe total por este producto.
     *
     * @return Importe total
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Obtiene el ID del producto en la comanda.
     *
     * @return ID del producto en la comanda
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del producto en la comanda.
     *
     * @param id Nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve una representación en texto del objeto.
     *
     * @return Cadena con información del producto en la comanda
     */
    @Override
    public String toString() {
        return "ProductoComandaDTO{" +
                "producto=" + producto +
                ", precioActual=" + precioActual +
                ", comentario='" + comentario + '\'' +
                ", cantidad=" + cantidad +
                ", importe=" + importe +
                '}';
    }
}