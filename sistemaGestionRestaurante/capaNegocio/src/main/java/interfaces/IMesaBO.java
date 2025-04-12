package interfaces;

import entidades.Mesa;
import enums.EstadoMesa;
import enums.TipoProducto;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Interfaz de negocio para gestionar las operaciones relacionadas con las mesas.
 * Define los métodos que deben implementar las clases de servicio de negocio
 * para interactuar con los datos y la gestión de mesas en el sistema.
 */
public interface IMesaBO {

    /**
     * Agrega nuevas mesas al sistema.
     * 
     * @param cantidadMesas La cantidad de mesas que se desea agregar.
     * @return {@code true} si las mesas fueron agregadas correctamente, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public boolean agregarMesas(int cantidadMesas) throws NegocioException;
    
    /**
     * Consulta todas las mesas registradas en el sistema.
     * 
     * @return Lista de todas las mesas disponibles en el sistema.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<Mesa> consultarMesas() throws NegocioException;
    
    /**
     * Consulta todas las mesas disponibles (que no están ocupadas).
     * 
     * @return Lista de las mesas que están disponibles para ser ocupadas.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<Mesa> consultarMesasDisponibles() throws NegocioException;
    
    /**
     * Cambia el estado de una mesa (por ejemplo, de disponible a ocupada).
     * 
     * @param idMesa El ID de la mesa cuyo estado se desea cambiar.
     * @param estadoMesa El nuevo estado que se asignará a la mesa.
     * @return {@code true} si el estado de la mesa se cambió correctamente, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public boolean cambiarEstadoMesa(Long idMesa, EstadoMesa estadoMesa) throws NegocioException;
}