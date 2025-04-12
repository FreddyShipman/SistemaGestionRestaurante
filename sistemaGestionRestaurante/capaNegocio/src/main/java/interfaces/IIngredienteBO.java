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
public interface IIngredienteBO {
    public List<Ingrediente> consultarTodosLosIngredientes() throws NegocioException;
    
    public boolean quitarIngredienteAlProducto(Long idIngredienteProducto) throws NegocioException;
    
    public Long obtenerNombresRepetidosDeProducto(String nombreIngrediente) throws NegocioException;
    
    public Ingrediente agregarIngredienteAlInventario(Ingrediente ingrediene) throws NegocioException;
    
    public List<Ingrediente> buscadorComandas(String nombre) throws NegocioException;
    
    public Ingrediente consultarIngredientePorId(Long idIngrediente) throws NegocioException;
    
    public Ingrediente modificarIngrediente(Ingrediente ingrediente) throws NegocioException;
}
