package BO;

import DAO.IngredienteProductoDAO;
import entidades.Ingrediente;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import interfaces.IIngredienteProductoDAO;
import java.util.List;

/**
 *
 * @author alfre
 */
public class IngredienteBO implements IIngredienteBO{
    IIngredienteDAO ingredienteDAO;
    IIngredienteProductoDAO ingredienteProductoDAO;

    public IngredienteBO(IIngredienteDAO ingredienteDAO) {
        this.ingredienteDAO = ingredienteDAO;
        this.ingredienteProductoDAO = IngredienteProductoDAO.getInstanceDAO();
    }
    
    @Override
    public List<Ingrediente> consultarTodosLosIngredientes() throws NegocioException {
        try {
            return ingredienteDAO.consultarTodosLosIngredientes();
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }    

    @Override
    public boolean quitarIngredienteAlProducto(Long idIngredienteProducto) throws NegocioException {
        try {
            return ingredienteProductoDAO.quitarIngredienteAlProducto(idIngredienteProducto);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Long obtenerNombresRepetidosDeProducto(String nombreIngrediente) throws NegocioException {
        try {
            return ingredienteDAO.obtenerNombresRepetidosDeProducto(nombreIngrediente);
        } catch (Exception e) {
            throw new NegocioException(nombreIngrediente);
        }
    }

    @Override
    public Ingrediente agregarIngredienteAlInventario(Ingrediente ingrediene) throws NegocioException {
        try {
            return ingredienteDAO.agregarIngredienteAlInventario(ingrediene);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Ingrediente> buscadorComandas(String nombre) throws NegocioException {
        try {
            return ingredienteDAO.buscadorComandas(nombre);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Ingrediente consultarIngredientePorId(Long idIngrediente) throws NegocioException {
        try {
            return ingredienteDAO.consultarIngredientePorId(idIngrediente);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Ingrediente modificarIngrediente(Ingrediente ingrediente) throws NegocioException {
        try {
            return ingredienteDAO.modificarIngrediente(ingrediente);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
    
    
}
