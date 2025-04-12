package interfaces;

import entidades.Ingrediente;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los metodos que tendra la Clase IngredienteDAO
 * 
 * @author janot
 */
public interface IIngredienteDAO {
    
    /**
     * Agrega un nuevo ingrediente a la bd.
     * 
     * @param ingrediente Ingrediente que se desea agregar.
     * @return Ingrediente con su id asignado.
     * @throws PersistenciaException Si no se logra la insercion.
     */
    public Ingrediente agregarIngredienteAlInventario(Ingrediente ingrediente) throws PersistenciaException;
    
    /**
     * Modifica un ingrediente de la bd.
     * 
     * @param ingrediente Ingrediente con los datos nuevos.
     * @return Ingrediente con los datos nuevos y su id.
     * @throws PersistenciaException Si no se logra modificar el ingrediente.
     */
    public Ingrediente modificarIngrediente(Ingrediente ingrediente) throws PersistenciaException;
    
    //METODO IGNORADO HASTA SABER DUDAS
    /**
     * Elimina un ingrediente de la bd.
     * @param idIngrediente Identificador del ingrediente que se desea eliminar.
     * @return true si se logra eliminar y false en caso contrario.
     * @throws PersistenciaException Si no encuentra el ingrediente a eliminar.
     */
    //public boolean eliminarIngrediente(Long idIngrediente) throws PersistenciaException;
    
    /**
     * Consulta todos los ingredientes de la bd.
     * 
     * @return Lista con todos los ingredientes registrados.
     * @throws PersistenciaException Si no se logra hacer la consulta.
     */
    public List<Ingrediente> consultarTodosLosIngredientes() throws PersistenciaException;
    
    /**
     * Consulta un ingrediente por su id.
     * 
     * @param idIngrediente Identificador del ingrediente que se desea consultar.
     * @return El ingrediente.
     * @throws PersistenciaException Si el id del ingrediente no existe.
     */
    public Ingrediente consultarIngredientePorId(Long idIngrediente) throws PersistenciaException;

    /**
     * Obtiene la cantidad de veces que se repite un ingrediente con el nombre especificado.
     * 
     * @param nombreIngrediente El nombre del ingrediente que se va a buscar.
     * @return La cantidad de veces que se repite el nombre del ingrediente en la base de datos.
     * @throws PersistenciaException Si ocurre un error al intentar acceder a la base de datos.
     */
    public Long obtenerNombresRepetidosDeProducto(String nombreIngrediente) throws PersistenciaException;

    /**
     * Realiza una búsqueda de ingredientes en la base de datos utilizando el nombre del ingrediente.
     * 
     * @param nombre El nombre o parte del nombre del ingrediente que se va a buscar.
     * @return Una lista de ingredientes que coinciden con el criterio de búsqueda.
     * @throws PersistenciaException Si ocurre un error al intentar realizar la consulta.
     */
    public List<Ingrediente> buscadorComandas(String nombre) throws PersistenciaException;
}