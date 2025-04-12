package BO;

import DAO.IngredienteProductoDAO;
import entidades.Ingrediente;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import interfaces.IIngredienteProductoDAO;
import interfaces.IProductoDAO;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Clase de negocio para la gestión de ingredientes. Implementa la interfaz {@link IIngredienteBO}
 * y utiliza las capas de acceso a datos {@link IIngredienteDAO} e {@link IIngredienteProductoDAO}
 * para realizar las operaciones sobre los ingredientes y su asociación con productos.
 */
public class IngredienteBO implements IIngredienteBO {

    /** Objeto de acceso a datos de ingredientes */
    private IIngredienteDAO ingredienteDAO;
    
    /** Objeto de acceso a datos de la relación ingrediente-producto */
    private IIngredienteProductoDAO ingredienteProductoDAO;

    /**
     * Constructor para inicializar el servicio de negocio con los objetos DAO.
     *
     * @param ingredienteDAO Objeto DAO para realizar las consultas de ingredientes
     */
    public IngredienteBO(IIngredienteDAO ingredienteDAO) {
        this.ingredienteDAO = ingredienteDAO;
        this.ingredienteProductoDAO = IngredienteProductoDAO.getInstanceDAO();
    }

    /**
     * Consulta todos los ingredientes disponibles.
     *
     * @return Lista de todos los ingredientes
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public List<Ingrediente> consultarTodosLosIngredientes() throws NegocioException {
        try {
            return ingredienteDAO.consultarTodosLosIngredientes();
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Elimina la relación entre un ingrediente y un producto.
     *
     * @param idIngredienteProducto ID del ingrediente-producto a eliminar
     * @return {@code true} si la operación fue exitosa, {@code false} de lo contrario
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public boolean quitarIngredienteAlProducto(Long idIngredienteProducto) throws NegocioException {
        try {
            return ingredienteProductoDAO.quitarIngredienteAlProducto(idIngredienteProducto);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Obtiene la cantidad de ingredientes con el mismo nombre que el proporcionado.
     *
     * @param nombreIngrediente Nombre del ingrediente a buscar
     * @return Cantidad de ingredientes con el mismo nombre
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public Long obtenerNombresRepetidosDeProducto(String nombreIngrediente) throws NegocioException {
        try {
            return ingredienteDAO.obtenerNombresRepetidosDeProducto(nombreIngrediente);
        } catch (Exception e) {
            throw new NegocioException(nombreIngrediente);
        }
    }

    /**
     * Agrega un nuevo ingrediente al inventario.
     *
     * @param ingrediente Objeto {@link Ingrediente} a agregar
     * @return Ingrediente agregado
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public Ingrediente agregarIngredienteAlInventario(Ingrediente ingrediente) throws NegocioException {
        try {
            return ingredienteDAO.agregarIngredienteAlInventario(ingrediente);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Busca ingredientes por su nombre.
     *
     * @param nombre Nombre del ingrediente a buscar
     * @return Lista de ingredientes que coinciden con el nombre proporcionado
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public List<Ingrediente> buscadorComandas(String nombre) throws NegocioException {
        try {
            return ingredienteDAO.buscadorComandas(nombre);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
}