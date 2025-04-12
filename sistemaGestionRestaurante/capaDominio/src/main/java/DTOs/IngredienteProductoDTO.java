package DTOs;

import entidades.Ingrediente;

/**
 *
 * @author janot
 */
/**
 * Clase DTO que representa la relación entre un producto y un ingrediente,
 * incluyendo la cantidad utilizada y su identificador.
 */
public class IngredienteProductoDTO {

    /** Ingrediente asociado al producto */
    private Ingrediente ingrediente;

    /** Cantidad del ingrediente utilizada en el producto */
    private double cantidad;

    /** Identificador único de la relación producto-ingrediente */
    private Long id;

    /**
     * Constructor que inicializa el ingrediente y la cantidad utilizada.
     *
     * @param ingrediente Ingrediente utilizado
     * @param cantidad Cantidad utilizada del ingrediente
     */
    public IngredienteProductoDTO(Ingrediente ingrediente, double cantidad) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el ingrediente asociado al producto.
     *
     * @return Ingrediente
     */
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    /**
     * Establece el ingrediente asociado al producto.
     *
     * @param ingrediente Ingrediente a asignar
     */
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * Obtiene la cantidad del ingrediente utilizada.
     *
     * @return Cantidad del ingrediente
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del ingrediente utilizada.
     *
     * @param cantidad Nueva cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el identificador único de la relación producto-ingrediente.
     *
     * @return ID de la relación
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la relación producto-ingrediente.
     *
     * @param id Nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }
}