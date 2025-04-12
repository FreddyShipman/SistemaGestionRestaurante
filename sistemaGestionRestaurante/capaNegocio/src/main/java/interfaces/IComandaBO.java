package interfaces;

import DTOs.ComandaDTO;
import DTOs.NuevaComandaDTO;
import DTOs.ProductoComandaDTO;
import entidades.Comanda;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import excepciones.NegocioException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Interfaz de negocio para gestionar las operaciones relacionadas con las comandas.
 * Define los métodos que deben implementar las clases de servicio de negocio
 * para interactuar con los datos de las comandas y productos asociados.
 */
public interface IComandaBO {

    /**
     * Crea una nueva comanda en el sistema.
     * 
     * @param comandaNueva Objeto de tipo {@link NuevaComandaDTO} con los datos de la nueva comanda.
     * @return Objeto {@link NuevaComandaDTO} con la comanda creada.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public NuevaComandaDTO crearComanda(NuevaComandaDTO comandaNueva) throws NegocioException;

    /**
     * Elimina una comanda del sistema.
     * 
     * @param id El ID de la comanda a eliminar.
     * @return {@code true} si la comanda se eliminó correctamente, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public boolean eliminarComanda(Long id) throws NegocioException;

    /**
     * Modifica una comanda existente.
     * 
     * @param comanda Objeto de tipo {@link ComandaDTO} con los datos de la comanda a modificar.
     * @return Objeto {@link Comanda} con la comanda modificada.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public Comanda modificarComanda(ComandaDTO comanda) throws NegocioException;

    /**
     * Agrega un producto a una comanda.
     * 
     * @param productoComandaDTO Objeto de tipo {@link ProductoComandaDTO} con los detalles del producto.
     * @return Objeto {@link ProductoComanda} con el producto agregado a la comanda.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public ProductoComanda agregarProductoAcomanda(ProductoComandaDTO productoComandaDTO) throws NegocioException;

    /**
     * Realiza una búsqueda de comandas por estado y rango de fechas.
     * 
     * @param estadoComanda El estado de las comandas a buscar.
     * @param desde La fecha de inicio del rango.
     * @param hasta La fecha de fin del rango.
     * @return Lista de comandas que cumplen con los criterios de búsqueda.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<Comanda> buscadorComandas(EstadoComanda estadoComanda, Date desde, Date hasta) throws NegocioException;

    /**
     * Consulta las comandas pendientes de ser entregadas.
     * 
     * @return Lista de comandas que están pendientes.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<Comanda> consultarComandasPendientes() throws NegocioException;

    /**
     * Cancela una comanda.
     * 
     * @param idComanda El ID de la comanda a cancelar.
     * @return Objeto {@link Comanda} con la comanda cancelada.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public Comanda cancelarComanda(Long idComanda) throws NegocioException;

    /**
     * Finaliza una comanda (la marca como entregada).
     * 
     * @param idComanda El ID de la comanda a finalizar.
     * @return Objeto {@link Comanda} con la comanda finalizada.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public Comanda finalizarComanda(Long idComanda) throws NegocioException;

    /**
     * Consulta una comanda por su ID.
     * 
     * @param idComanda El ID de la comanda a consultar.
     * @return Objeto {@link Comanda} con los detalles de la comanda solicitada.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public Comanda consultarComandaPorID(Long idComanda) throws NegocioException;

    /**
     * Quita un producto de una comanda.
     * 
     * @param idProductoDeComanda El ID del producto de la comanda a quitar.
     * @return {@code true} si el producto se quitó correctamente, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public boolean quitarProductoDecomanda(Long idProductoDeComanda) throws NegocioException;

    /**
     * Consulta los productos de una comanda específica.
     * 
     * @param idComanda El ID de la comanda de la cual se desean consultar los productos.
     * @return Lista de objetos {@link ProductoComandaDTO} con los productos de la comanda.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<ProductoComandaDTO> consultarProductosDeComanda(Long idComanda) throws NegocioException;
}