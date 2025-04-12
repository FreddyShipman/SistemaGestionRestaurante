package interfaces;

import DTOs.IngredienteProductoDTO;
import entidades.Ingrediente;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Interfaz de negocio para gestionar las operaciones relacionadas con los ingredientes.
 * Define los métodos que deben implementar las clases de servicio de negocio
 * para interactuar con los datos de los ingredientes.
 */
public interface IIngredienteBO {

    /**
     * Consulta todos los ingredientes registrados en el sistema.
     * 
     * @return Lista de todos los ingredientes disponibles.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<Ingrediente> consultarTodosLosIngredientes() throws NegocioException;
    
    /**
     * Elimina un ingrediente asociado a un producto en el inventario.
     * 
     * @param idIngredienteProducto El ID del ingrediente a eliminar.
     * @return {@code true} si el ingrediente se eliminó correctamente, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public boolean quitarIngredienteAlProducto(Long idIngredienteProducto) throws NegocioException;

    /**
     * Obtiene la cantidad de productos que contienen un ingrediente con el mismo nombre.
     * 
     * @param nombreIngrediente El nombre del ingrediente a buscar.
     * @return El número de productos que contienen un ingrediente con el nombre proporcionado.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public Long obtenerNombresRepetidosDeProducto(String nombreIngrediente) throws NegocioException;

    /**
     * Agrega un nuevo ingrediente al inventario.
     * 
     * @param ingrediente El objeto {@link Ingrediente} con los datos del nuevo ingrediente.
     * @return El ingrediente agregado al inventario.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public Ingrediente agregarIngredienteAlInventario(Ingrediente ingrediente) throws NegocioException;
    
    /**
     * Realiza una búsqueda de ingredientes por nombre.
     * 
     * @param nombre El nombre del ingrediente a buscar.
     * @return Lista de ingredientes que coinciden con el nombre proporcionado.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public List<Ingrediente> buscadorComandas(String nombre) throws NegocioException;
}