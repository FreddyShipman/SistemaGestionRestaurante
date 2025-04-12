package BO;

import entidades.Mesa;
import enums.EstadoMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IMesaBO;
import interfaces.IMesaDAO;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Clase de negocio para la gestión de mesas. Implementa la interfaz {@link IMesaBO}
 * y utiliza la capa de acceso a datos {@link IMesaDAO} para realizar operaciones relacionadas
 * con las mesas en el sistema.
 */
public class MesaBO implements IMesaBO {

    /** Objeto de acceso a datos de mesas */
    private IMesaDAO mesaDAO;

    /**
     * Constructor para inicializar el servicio de negocio con el objeto DAO de mesas.
     *
     * @param mesaDAO Objeto DAO para realizar las operaciones sobre mesas
     */
    public MesaBO(IMesaDAO mesaDAO) {
        this.mesaDAO = mesaDAO;
    }

    /**
     * Agrega una cantidad específica de mesas al sistema.
     *
     * @param cantidadMesas La cantidad de mesas a agregar
     * @return {@code true} si las mesas se agregaron correctamente, {@code false} de lo contrario
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public boolean agregarMesas(int cantidadMesas) throws NegocioException {
        try {
            return mesaDAO.agregarMesas(cantidadMesas);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta todas las mesas disponibles en el sistema.
     *
     * @return Lista de todas las mesas
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public List<Mesa> consultarMesas() throws NegocioException {
        try {
            return mesaDAO.consultarMesas();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta las mesas que están disponibles para ser ocupadas.
     *
     * @return Lista de mesas disponibles
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public List<Mesa> consultarMesasDisponibles() throws NegocioException {
        try {
            return mesaDAO.consultarMesasDisponibles();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Cambia el estado de una mesa específica.
     *
     * @param idMesa El ID de la mesa a la que se le cambiará el estado
     * @param estadoMesa El nuevo estado para la mesa
     * @return {@code true} si el estado de la mesa se cambió correctamente, {@code false} de lo contrario
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public boolean cambiarEstadoMesa(Long idMesa, EstadoMesa estadoMesa) throws NegocioException {
        try {
            mesaDAO.cambiarEstadoDeMesa(idMesa, estadoMesa);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }

        return true;
    }
}