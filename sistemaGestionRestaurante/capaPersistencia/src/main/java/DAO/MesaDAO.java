package DAO;

import conexion.Conexion;
import entidades.Comanda;
import entidades.Mesa;
import entidades.Producto;
import enums.EstadoMesa;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author janot
 */
/**
 * Clase que implementa la interfaz IMesaDAO para manejar las operaciones de persistencia
 * relacionadas con las mesas en la base de datos.
 */
public class MesaDAO implements IMesaDAO{
    
    private static MesaDAO instanceMesaDAO;
    
    /**
     * Constructor privado para evitar instancias múltiples.
     */
    private MesaDAO() {
    }
    
    /**
     * Método para obtener la única instancia de MesaDAO.
     * Utiliza el patrón Singleton para asegurar que solo haya una instancia de esta clase.
     *
     * @return Instancia de MesaDAO.
     */
    public static MesaDAO getInstanceDAO() {
        if (instanceMesaDAO == null) {
            instanceMesaDAO = new MesaDAO();
        }
        return instanceMesaDAO;
    }
    
    /**
     * Agrega un número de mesas al sistema.
     * 
     * @param cantidadMesas La cantidad de mesas a agregar.
     * @return true si las mesas fueron agregadas correctamente, false si ocurrió un error.
     * @throws PersistenciaException Si ocurre un error al registrar las mesas.
     */
    @Override
    public boolean agregarMesas(int cantidadMesas) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        try {
            em.getTransaction().begin();
            
            for (int i = 1; i <= cantidadMesas; i++) {
                em.persist(new Mesa(i, EstadoMesa.DISPONIBLE));
            }
            
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudieron registrar las " + cantidadMesas + " mesas." + e.getMessage(), e);
        }
    }

    /**
     * Consulta todas las mesas registradas en la base de datos.
     *
     * @return Lista de todas las mesas.
     * @throws PersistenciaException Si ocurre un error al consultar las mesas.
     */
    @Override
    public List<Mesa> consultarMesas() throws PersistenciaException {
        List<Mesa> mesas = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        try {
            mesas = em.createQuery("SELECT m FROM Mesa m", Mesa.class).getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar todas las mesas", e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return mesas;
    }

    /**
     * Consulta todas las mesas que están disponibles.
     *
     * @return Lista de mesas disponibles.
     * @throws PersistenciaException Si ocurre un error al consultar las mesas disponibles.
     */
    @Override
    public List<Mesa> consultarMesasDisponibles() throws PersistenciaException {
        List<Mesa> mesas = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        String jpql = "SELECT m FROM Mesa m WHERE m.estadoMesa= :estadoMesa";
        
        try {
            TypedQuery<Mesa> query = em.createQuery(jpql, Mesa.class);
            query.setParameter("estadoMesa", EstadoMesa.DISPONIBLE);
            mesas = query.getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar las mesas disponibles", e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return mesas;
    }

    /**
     * Cambia el estado de una mesa en la base de datos.
     *
     * @param idMesa El ID de la mesa a actualizar.
     * @param estadoMesa El nuevo estado de la mesa.
     * @return true si el estado fue actualizado correctamente, false si ocurrió un error.
     * @throws PersistenciaException Si ocurre un error al actualizar el estado de la mesa.
     */
    @Override
    public boolean cambiarEstadoDeMesa(Long idMesa, EstadoMesa estadoMesa) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Mesa mesa = em.find(Mesa.class, idMesa);
        
        if(mesa == null){
            throw new PersistenciaException("Error: El id de la mesa no existe");
        }
        
        mesa.setEstadoMesa(estadoMesa);
        
        try {
            em.getTransaction().begin();
            em.merge(mesa);
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo actualizar el estado de la mesa: " + e.getMessage(), e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}