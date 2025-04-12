package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa la relación entre un ingrediente y un producto en el sistema.
 * Cada producto puede estar compuesto por varios ingredientes en cantidades específicas.
 * 
 * @author alfre
 */
@Entity
@Table(name = "IngredientesProductos")
public class IngredienteProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** Identificador único de la relación entre ingrediente y producto. */
    @Id
    @Column(name = "idIngredienteProducto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Producto al que pertenece este ingrediente. */
    @ManyToOne()
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    
    /** Ingrediente utilizado en la composición del producto. */
    @ManyToOne()
    @JoinColumn(name = "idIngrediente", nullable = false)
    private Ingrediente ingrediente;
    
    /** Cantidad del ingrediente utilizada en el producto. */
    @Column(name = "cantidad", nullable = false)
    private double cantidad;

    /**
     * Constructor por defecto.
     */
    public IngredienteProducto() {
    }

    /**
     * Constructor con parámetros para inicializar los atributos.
     * 
     * @param producto Producto que contiene este ingrediente.
     * @param ingrediente Ingrediente utilizado en el producto.
     * @param cantidad Cantidad del ingrediente utilizada.
     */
    public IngredienteProducto(Producto producto, Ingrediente ingrediente, double cantidad) {
        this.producto = producto;
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el identificador único de la relación.
     * 
     * @return ID de la relación ingrediente-producto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la relación.
     * 
     * @param id ID de la relación ingrediente-producto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el producto asociado a esta relación.
     * 
     * @return Producto relacionado con el ingrediente.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado a esta relación.
     * 
     * @param producto Producto que contiene el ingrediente.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene el ingrediente asociado a esta relación.
     * 
     * @return Ingrediente utilizado en el producto.
     */
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    /**
     * Establece el ingrediente asociado a esta relación.
     * 
     * @param ingrediente Ingrediente utilizado en el producto.
     */
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * Obtiene la cantidad del ingrediente utilizada en el producto.
     * 
     * @return Cantidad del ingrediente.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del ingrediente utilizada en el producto.
     * 
     * @param cantidad Cantidad del ingrediente.
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString() {
        return "IngredienteProducto{" + "id=" + id + ", producto=" + producto.getNombre() + ", ingrediente=" + ingrediente.getNombre() + ", cantidad=" + cantidad + '}';
    }
}
