package manejadoresDeObjetoNegocio;

import BO.ClienteBO;
import BO.ComandaBO;
import BO.IngredienteBO;
import BO.MesaBO;
import BO.ProductoBO;
import DAO.ClienteDAO;
import DAO.ComandaDAO;
import DAO.IngredienteDAO;
import DAO.MesaDAO;
import DAO.ProductoDAO;
import entidades.Ingrediente;
import interfaces.IClienteBO;
import interfaces.IClienteDAO;
import interfaces.IComandaBO;
import interfaces.IComandaDAO;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import interfaces.IMesaBO;
import interfaces.IMesaDAO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;

/**
 *
 * @author janot
 */
/**
 * Clase encargada de manejar la creación de objetos de negocio (BO).
 * Esta clase centraliza la creación de instancias de las diferentes clases BO,
 * facilitando la administración de la lógica de negocio dentro de la aplicación.
 */
public class ManejadorObjetosNegocio {
    
    /**
     * Crea una instancia de IProductoBO.
     * 
     * @return Una instancia de ProductoBO, implementada por IProductoBO.
     */
    public static IProductoBO crearProductoBO(){
        IProductoDAO productoDAO = ProductoDAO.getInstanceDAO();
        IProductoBO productoBO = new ProductoBO(productoDAO);
        return productoBO;
    }
    
    /**
     * Crea una instancia de IMesaBO.
     * 
     * @return Una instancia de MesaBO, implementada por IMesaBO.
     */
    public static IMesaBO crearMesaBO(){
        IMesaDAO mesaDAO = MesaDAO.getInstanceDAO();
        IMesaBO mesaBO = new MesaBO(mesaDAO);
        return mesaBO;
    }
    
    /**
     * Crea una instancia de IClienteBO.
     * 
     * @return Una instancia de ClienteBO, implementada por IClienteBO.
     */
    public static IClienteBO crearClienteBO(){
        IClienteDAO clienteDAO = ClienteDAO.getInstanceDAO();
        IClienteBO clienteBO = new ClienteBO(clienteDAO);
        return clienteBO;
    }
    
    /**
     * Crea una instancia de IComandaBO.
     * 
     * @return Una instancia de ComandaBO, implementada por IComandaBO.
     */
    public static IComandaBO crearComandaBO(){
        IComandaDAO comandaDAO = ComandaDAO.getInstanceDAO();
        IComandaBO comandaBO = new ComandaBO(comandaDAO);
        return comandaBO;
    }
    
    /**
     * Crea una instancia de IIngredienteBO.
     * 
     * @return Una instancia de IngredienteBO, implementada por IIngredienteBO.
     */
    public static IIngredienteBO crearIngredienteBO(){
        IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstanceDAO();
        IIngredienteBO ingredienteBO = new IngredienteBO(ingredienteDAO);
        return ingredienteBO;
    }
}