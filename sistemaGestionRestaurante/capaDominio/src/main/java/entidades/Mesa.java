package entidades;

import enums.EstadoMesa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa una mesa de un restaurante
 * 
 * @author janot
 */
/**
 * Entidad que representa una mesa en el sistema (por ejemplo, en un restaurante).
 * Cada mesa tiene un número único y un estado que puede indicar si está disponible, ocupada, reservada, etc.
 *
 * Está mapeada a la tabla "Mesas" en la base de datos.
 */
@Entity
@Table(name = "Mesas")
public class Mesa implements Serializable {

    /** Identificador de versión para la serialización */
    private static final long serialVersionUID = 1L;

    /** Identificador único de la mesa */
    @Id
    @Column(name = "idMesa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Número asignado a la mesa */
    @Column(name = "numeroMesa", nullable = false)
    private Integer numeroMesa;

    /** Estado actual de la mesa (ej. DISPONIBLE, OCUPADA, RESERVADA) */
    @Column(name = "estadoMesa", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EstadoMesa estadoMesa;

    /**
     * Constructor por defecto requerido por JPA.
     */
    public Mesa() {
    }

    /**
     * Constructor para crear una mesa con número y estado específico.
     *
     * @param numeroMesa Número de la mesa
     * @param estadoMesa Estado actual de la mesa
     */
    public Mesa(Integer numeroMesa, EstadoMesa estadoMesa) {
        this.numeroMesa = numeroMesa;
        this.estadoMesa = estadoMesa;
    }

    /**
     * Obtiene el identificador único de la mesa.
     *
     * @return ID de la mesa
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la mesa.
     *
     * @param id ID nuevo de la mesa
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el número asignado a la mesa.
     *
     * @return Número de la mesa
     */
    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    /**
     * Establece el número asignado a la mesa.
     *
     * @param numeroMesa Nuevo número de la mesa
     */
    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    /**
     * Obtiene el estado actual de la mesa.
     *
     * @return Estado de la mesa
     */
    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    /**
     * Establece el estado actual de la mesa.
     *
     * @param estadoMesa Nuevo estado de la mesa
     */
    public void setEstadoMesa(EstadoMesa estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    /**
     * Representación textual de la mesa.
     *
     * @return Cadena que representa la mesa por su número
     */
    @Override
    public String toString() {
        return "Mesa: " + this.getNumeroMesa();
    }
}