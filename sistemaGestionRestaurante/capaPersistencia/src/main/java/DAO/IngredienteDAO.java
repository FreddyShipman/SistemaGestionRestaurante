package DAO;

import conexion.Conexion;
import entidades.Ingrediente;
import excepciones.PersistenciaException;
import interfaces.IIngredienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author janot
 */
/**
 * Clase que implementa la interfaz IIngredienteDAO para manejar las operaciones de persistencia
 * relacionadas con los ingredientes en la base de datos.
 */
public class IngredienteDAO implements IIngredienteDAO{

    private static IngredienteDAO instanceIngredienteDAO;
    
    /**
     * Constructor privado para evitar instancias múltiples.
     */
    private IngredienteDAO(){
    }
    
    /**
     * Método para obtener la única instancia de IngredienteDAO.
     * Utiliza el patrón Singleton para asegurar que solo haya una instancia de esta clase.
     *
     * @return Instancia de IngredienteDAO.
     */
    public static IngredienteDAO getInstanceDAO() {
        if (instanceIngredienteDAO == null) {
            instanceIngredienteDAO = new IngredienteDAO();
        }
        return instanceIngredienteDAO;
    }    

    /**
     * Agrega un ingrediente al inventario de la base de datos.
     *
     * @param ingrediente El ingrediente a agregar.
     * @return El ingrediente persistido con su ID generado.
     * @throws PersistenciaException Si ocurre un error al persistir el ingrediente.
     */
    @Override
    public Ingrediente agregarIngredienteAlInventario(Ingrediente ingrediente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();

        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }

        try {
            em.getTransaction().begin();
            em.persist(ingrediente);
            em.getTransaction().commit();

            if (ingrediente.getId() == null) {
                throw new PersistenciaException("Error: No se generó un ID para el producto.");
            }
            return ingrediente;

        } catch (PersistenciaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo registrar el ingrediente: " + e.getMessage(), e);

        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Método no soportado para modificar un ingrediente.
     *
     * @param ingrediente El ingrediente a modificar.
     * @throws UnsupportedOperationException Siempre lanza una excepción indicando que la operación no está soportada.
     */
    @Override
    public Ingrediente modificarIngrediente(Ingrediente ingrediente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Método no implementado.
    }

    /**
     * Consulta todos los ingredientes registrados en la base de datos.
     *
     * @return Lista de todos los ingredientes.
     * @throws PersistenciaException Si ocurre un error al consultar los ingredientes.
     */
    @Override
    public List<Ingrediente> consultarTodosLosIngredientes() throws PersistenciaException {
        List<Ingrediente> ingredientes = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        try {
            ingredientes = em.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar a todos los productos", e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return ingredientes;
    }

    /**
     * Método no soportado para consultar un ingrediente por su ID.
     *
     * @param idIngrediente El ID del ingrediente a consultar.
     * @throws UnsupportedOperationException Siempre lanza una excepción indicando que la operación no está soportada.
     */
    @Override
    public Ingrediente consultarIngredientePorId(Long idIngrediente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Método no implementado.
    }

    /**
     * Obtiene la cantidad de ingredientes que tienen un nombre repetido en la base de datos.
     *
     * @param nombreIngrediente El nombre del ingrediente a buscar.
     * @return La cantidad de veces que aparece ese ingrediente en la base de datos.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    @Override
    public Long obtenerNombresRepetidosDeProducto(String nombreIngrediente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        try {
            return em.createQuery("SELECT COUNT(i) FROM Ingrediente i WHERE i.nombre = :nombre", Long.class)
                     .setParameter("nombre", nombreIngrediente)
                     .getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la cantidad de repetidos", e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Realiza una búsqueda de ingredientes en base al nombre del ingrediente.
     *
     * @param nombre El nombre del ingrediente a buscar (puede ser parcial).
     * @return Lista de ingredientes que coinciden con el criterio de búsqueda.
     * @throws PersistenciaException Si ocurre un error al realizar la búsqueda.
     */
    @Override
    public List<Ingrediente> buscadorComandas(String nombre) throws PersistenciaException {
        List<Ingrediente> ingredientes = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        String jpql = "SELECT i FROM Ingrediente i WHERE (:nombreIngrediente IS NULL OR i.nombre LIKE CONCAT('%', :nombreIngrediente, '%'))";
        
        try {
            TypedQuery<Ingrediente> query = em.createQuery(jpql, Ingrediente.class);
            query.setParameter("nombreIngrediente", nombre);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al realizar la consulta de búsqueda", e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}