package interfaces;

import entidades.IngredienteProducto;
import entidades.Producto;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los metodos que tendra la Clase ProductoDAO
 * @author janot
 */
public interface IProductoDAO {
    /**
     * Agrega un nuevo producto a la bd.
     * 
     * @param producto Producto que se desea agregar a la bd.
     * @return Producto con su id.
     * @throws PersistenciaException Si no se logra la insercion, si no se pudo obtener la conexion, y si
     * no se pudo generar
     */
    public Producto agregarProductoAlMenu(Producto producto) throws PersistenciaException;
    
    /**
     * Modifica un producto de la bd
     * @param producto Producto con los datos nuevos
     * @return Producto con los datos actualizados.
     * @throws PersistenciaException Si el producto que se desea modificar no existe, o si no se
     * pudo lograr la conexion
     */
    public Producto modificarProductoDelMenu(Producto producto) throws PersistenciaException;

    /**
     * Inhabilita un Producto de la base de datos
     * 
     * @param idProducto Id del producto que se desea inhabilitar.
     * @return true si se logra inhabilitar el producto y false en caso contrario.
     * @throws PersistenciaException Si el producto no existe.
     */
    public boolean inhabilitarProducto(Long idProducto) throws PersistenciaException;
    
    /**
     * Consulta un producto por su nombre
     * @param idProducto Identificador del producto que se desea consultar
     * @return Producto con sus datos
     * @throws PersistenciaException Si el producto no existe.
     */
    public Producto consultarProductoPorId(Long idProducto) throws PersistenciaException;
    
    /**
     * Consulta todos los productos que hay registrados en la bd.
     * 
     * @return Lista con los productos.
     * @throws PersistenciaException Si no se logra hacer la consulta
     */
    public List<Producto> consultarTodosLosProductos() throws PersistenciaException;
    
    /**
     * Consulta los Ingredientes que tiene el producto.
     * 
     * @param idProducto Identificador del producto al que se desea ver los ingredientesProductos.
     * @return Lista con los ingredientes del Producto.
     * @throws PersistenciaException Si no se logra hacer la consulta.
     */
    public List<IngredienteProducto> consultarIngredientesDelProducto(Long idProducto) throws PersistenciaException; 
    
    public List<Producto> consultarProductosHabilitados() throws PersistenciaException;
    
}
