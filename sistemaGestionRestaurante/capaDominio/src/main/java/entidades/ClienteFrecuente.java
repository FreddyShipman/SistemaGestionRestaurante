package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author janot
 */
/**
 * Entidad que representa a un cliente frecuente del sistema.
 * 
 * Hereda los atributos de la clase {@link Cliente} y puede ser extendida
 * para agregar beneficios especiales o historial de compras en el futuro.
 * 
 * Está mapeada a la tabla "ClienteFrecuente" en la base de datos.
 */
@Entity
@Table(name = "ClienteFrecuente")
public class ClienteFrecuente extends Cliente implements Serializable {

    /** Identificador de versión para la serialización */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto requerido por JPA.
     */
    public ClienteFrecuente() {
        super();
    }

    /**
     * Constructor que permite inicializar un cliente frecuente con datos personales.
     *
     * @param telefono Número de teléfono del cliente
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido paterno
     * @param apellidoMaterno Apellido materno
     * @param correoElectronico Correo electrónico
     * @param fechaRegistro Fecha en la que se registró el cliente
     */
    public ClienteFrecuente(String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, Date fechaRegistro) {
        super(telefono, nombre, apellidoPaterno, apellidoMaterno, correoElectronico, fechaRegistro);
    }
}