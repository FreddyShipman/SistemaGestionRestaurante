package entidades;

import enums.UnidadDeMedida;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa un ingrediente utilizado en la preparación de productos.
 * Cada ingrediente tiene un nombre, una unidad de medida y una cantidad en stock.
 * 
 * @author alfre
 */
@Entity
@Table(name = "Ingredientes")
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** 
     * Identificador único del ingrediente. 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idIngrediente", nullable = false)
    private Long id;
    
    /** 
     * Nombre del ingrediente. 
     */
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    
    /** 
     * Unidad de medida utilizada para el ingrediente. 
     * Se utiliza un enum que tien como tipo(PIEZAS, GRAMOS, MILILITROS)
     */
    @Column(name = "unidadMedida", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UnidadDeMedida unidadMedida;
    
    /** 
     * Cantidad disponible del ingrediente en stock. 
     */
    @Column(name = "stock", nullable = false)
    private Double stock;
    
    /* Lista de Ingredientes para elaborar el producto
     * Relacion uno a muchos, bidireccional, la entidad IngredienteProducto 
     * es la dueña de la relacion.
     */
    @OneToMany(mappedBy = "ingrediente", fetch = FetchType.EAGER)
    private List<IngredienteProducto> ingredientes = new ArrayList<>();

    /**
     * Constructor por defecto.
     */
    public Ingrediente() {
    }

    /**
     * Constructor que inicializa los atributos del ingrediente excepto el ID.
     * 
     * @param nombre Nombre del ingrediente.
     * @param unidadMedida Unidad de medida utilizada para el ingrediente.
     * @param stock Cantidad disponible en stock.
     */
    public Ingrediente(String nombre, UnidadDeMedida unidadMedida, Double stock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    /**
     * Obtiene el ID del ingrediente.
     * 
     * @return ID del ingrediente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del ingrediente.
     * 
     * @param id Nuevo ID del ingrediente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del ingrediente.
     * 
     * @return Nombre del ingrediente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del ingrediente.
     * 
     * @param nombre Nuevo nombre del ingrediente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la unidad de medida del ingrediente.
     * 
     * @return Unidad de medida del ingrediente.
     */
    public UnidadDeMedida getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Establece la unidad de medida del ingrediente.
     * 
     * @param unidadMedida Nueva unidad de medida del ingrediente.
     */
    public void setUnidadMedida(UnidadDeMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    /**
     * Obtiene la cantidad disponible del ingrediente en stock.
     * 
     * @return Cantidad en stock.
     */
    public Double getStock() {
        return stock;
    }

    /**
     * Establece la cantidad disponible del ingrediente en stock.
     * 
     * @param stock Nueva cantidad en stock.
     */
    public void setStock(Double stock) {
        this.stock = stock;
    }

    public List<IngredienteProducto> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteProducto> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    

    @Override
    public String toString() {
        if(unidadMedida == unidadMedida.GRAMOS){
            return nombre + "   (gramos).";
        }
        else if(unidadMedida == unidadMedida.MILILITROS){
            return nombre + "   (ml).";
        }
        else{
            return nombre + "   (piezas).";
        }
    }
}
