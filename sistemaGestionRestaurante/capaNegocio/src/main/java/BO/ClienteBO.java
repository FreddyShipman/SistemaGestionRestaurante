package BO;

import DAO.ClienteDAO;
import entidades.Cliente;
import excepciones.NegocioException;
import interfaces.IClienteBO;
import interfaces.IClienteDAO;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Clase de negocio para la gestión de clientes. Implementa la interfaz {@link IClienteBO}
 * y utiliza la capa de acceso a datos {@link IClienteDAO} para realizar las operaciones sobre los clientes.
 */
public class ClienteBO implements IClienteBO {

    /** Objeto de acceso a datos de clientes */
    private IClienteDAO clienteDAO;

    /**
     * Constructor para inicializar el servicio de negocio con el objeto DAO.
     *
     * @param clienteDAO Objeto DAO para realizar las consultas de clientes
     */
    public ClienteBO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    /**
     * Consulta todos los clientes en la base de datos.
     *
     * @return Lista de todos los clientes registrados
     * @throws NegocioException Si ocurre un error en la capa de negocio o al consultar los datos
     */
    @Override
    public List<Cliente> consultarTodosLosClientes() throws NegocioException {
        try {
            // Llamada al método DAO para obtener todos los clientes
            return clienteDAO.consultarTodosLosClientes();
        } catch (Exception e) {
            // Si ocurre una excepción, se lanza una NegocioException con el mensaje de error
            throw new NegocioException(e.getMessage());
        }
    }
}