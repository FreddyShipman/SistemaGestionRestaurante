package interfaces;

import entidades.Mesa;
import enums.EstadoMesa;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Interfaz que define las operaciones relacionadas con la gestión de mesas en la base de datos.
 */
public interface IMesaDAO {

    /**
     * Agrega un número específico de mesas a la base de datos.
     * 
     * @param cantidadMesas El número de mesas que se desea agregar.
     * @return true si las mesas se agregaron correctamente, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al intentar acceder a la base de datos o al insertar los registros.
     */
    public boolean agregarMesas(int cantidadMesas) throws PersistenciaException;

    /**
     * Consulta todas las mesas registradas en la base de datos.
     * 
     * @return Una lista de todas las mesas registradas.
     * @throws PersistenciaException Si ocurre un error al intentar realizar la consulta.
     */
    public List<Mesa> consultarMesas() throws PersistenciaException;

    /**
     * Consulta todas las mesas disponibles (no ocupadas) en la base de datos.
     * 
     * @return Una lista de mesas disponibles.
     * @throws PersistenciaException Si ocurre un error al intentar realizar la consulta.
     */
    public List<Mesa> consultarMesasDisponibles() throws PersistenciaException;

    /**
     * Cambia el estado de una mesa específica.
     * 
     * @param idMesa El ID de la mesa cuyo estado se desea cambiar.
     * @param estadoMesa El nuevo estado que se desea asignar a la mesa.
     * @return true si el estado de la mesa se cambió correctamente, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al intentar actualizar la mesa en la base de datos.
     */
    public boolean cambiarEstadoDeMesa(Long idMesa, EstadoMesa estadoMesa) throws PersistenciaException;
}