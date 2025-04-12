package interfaces;

import DTOs.NuevoProductoDTO;
import DTOs.ProductoDTO;
import entidades.IngredienteProducto;
import entidades.Producto;
import enums.TipoProducto;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Interfaz de negocio para gestionar las operaciones relacionadas con los productos del menú.
 * Define los métodos que deben implementar las clases de servicio de negocio para interactuar
 * con los productos en el sistema.
 */
public interface IProductoBO {

    /**
     * Agrega un nuevo producto al menú.
     * 
     * @param nuevoProducto El DTO con los datos del nuevo producto a agregar.
     * @return El DTO del producto que fue agregado.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public ProductoDTO agregarProductoAlMenu(NuevoProductoDTO nuevoProducto) throws NegocioException;
    
    /**
     * Consulta un producto por su ID.
     * 
     * @param idProducto El ID del producto a consultar.
     * @return El producto consultado.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public Producto consultarProductoPorId(Long idProducto) throws NegocioException;
    
    /**
     * Modifica un producto existente en el menú.
     * 
     * @param producto El DTO del producto a modificar.
     * @return El producto modificado.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public Producto modificarProducto(ProductoDTO producto) throws NegocioException;
    
    /**
     * Inhabilita un producto del menú (lo desactiva).
     * 
     * @param idProducto El ID del producto a inhabilitar.
     * @return {@code true} si el producto fue inhabilitado correctamente, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public boolean inhabilitarProductoDelMenu(Long idProducto) throws NegocioException;
    
    /**
     * Habilita un producto del menú (lo activa).
     * 
     * @param idProducto El ID del producto a habilitar.
     * @return {@code true} si el producto fue habilitado correctamente, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public boolean habilitarProductoDelMenu(Long idProducto) throws NegocioException;
    
    /**
     * Consulta los ingredientes de un producto.
     * 
     * @param idProducto El ID del producto cuyos ingredientes se quieren consultar.
     * @return Lista de ingredientes asociados al producto.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<IngredienteProducto> consultarIngredientesProducto(Long idProducto) throws NegocioException;
    
    /**
     * Consulta todos los productos habilitados en el menú.
     * 
     * @return Lista de productos habilitados.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<Producto> consultarProductosHabilitados() throws NegocioException;
    
    /**
     * Consulta todos los productos del menú.
     * 
     * @return Lista de todos los productos.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<Producto> consultarTodosLosProductos() throws NegocioException;
    
    /**
     * Realiza una búsqueda de productos según un tipo específico y un término de búsqueda.
     * 
     * @param tipo El tipo de producto a buscar.
     * @param busqueda El término de búsqueda que se utilizará.
     * @return Lista de productos que coinciden con los criterios de búsqueda.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<Producto> busquedaProducto(TipoProducto tipo, String busqueda) throws NegocioException;
}