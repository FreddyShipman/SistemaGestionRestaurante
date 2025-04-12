package interfaces;

import entidades.Cliente;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Interfaz de negocio para gestionar las operaciones relacionadas con los clientes.
 * Define los métodos que deben implementar las clases de servicio de negocio
 * para interactuar con los datos de los clientes.
 */
public interface IClienteBO {

    /**
     * Consulta todos los clientes registrados en el sistema.
     * 
     * @return Lista de todos los clientes
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    public List<Cliente> consultarTodosLosClientes() throws NegocioException;
}