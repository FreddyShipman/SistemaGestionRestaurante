package BO;

import DAO.IngredienteProductoDAO;
import DTOs.IngredienteProductoDTO;
import DTOs.NuevoProductoDTO;
import DTOs.ProductoDTO;
import entidades.IngredienteProducto;
import entidades.Producto;
import enums.TipoProducto;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IIngredienteProductoDAO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;
import java.util.List;
import mappers.ProductoMapper;

/**
 *
 * @author janot
 */
/**
 * Clase de negocio para gestionar los productos en el menú. Implementa la interfaz {@link IProductoBO}
 * y utiliza la capa de acceso a datos {@link IProductoDAO} y {@link IIngredienteProductoDAO} para realizar
 * las operaciones relacionadas con productos y sus ingredientes.
 */
public class ProductoBO implements IProductoBO {
    
    /** Objeto de acceso a datos de productos */
    private IProductoDAO productoDAO;
    
    /** Objeto de acceso a datos de ingredientes de productos */
    private IIngredienteProductoDAO ingredienteProductoDAO;

    /**
     * Constructor para inicializar el servicio de negocio con los objetos DAO correspondientes.
     *
     * @param productoDAO Objeto DAO para realizar las operaciones sobre productos
     */
    public ProductoBO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
        this.ingredienteProductoDAO = IngredienteProductoDAO.getInstanceDAO();
    }
    
    /**
     * Agrega un nuevo producto al menú, junto con sus ingredientes.
     *
     * @param nuevoProducto DTO que contiene los datos del nuevo producto a agregar
     * @return DTO del producto recién agregado
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    @Override
    public ProductoDTO agregarProductoAlMenu(NuevoProductoDTO nuevoProducto) throws NegocioException {
        Producto producto = ProductoMapper.toEntity(nuevoProducto);
        List<IngredienteProducto> ingredientesProducto = producto.getIngredientes();
        
        try {
            Producto productoRegistrado = productoDAO.agregarProductoAlMenu(producto);    
            
            for (IngredienteProductoDTO ingredienteProductoDTO : nuevoProducto.getIngredientesProductos()) {
                ingredientesProducto.add(new IngredienteProducto(productoRegistrado, ingredienteProductoDTO.getIngrediente(), ingredienteProductoDTO.getCantidad()));
            }
            
            try {
                for (IngredienteProducto ingredienteProducto : ingredientesProducto) {
                    ingredienteProductoDAO.asignarIngredienteAlProducto(productoRegistrado.getId(), ingredienteProducto.getIngrediente().getId(), ingredienteProducto.getCantidad());
                }
            } catch (PersistenciaException e) {
                throw new NegocioException(e.getMessage());
            }
            
            return ProductoMapper.toDTO(productoRegistrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error: No se pudo guardar el producto " + nuevoProducto.getNombre() + " a la BD", e);
        }       
    }

    /**
     * Consulta todos los productos habilitados en el menú.
     *
     * @return Lista de productos habilitados
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    @Override
    public List<Producto> consultarProductosHabilitados() throws NegocioException {
        try {
            return productoDAO.consultarProductosHabilitados();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta todos los productos registrados en el menú, habilitados o no.
     *
     * @return Lista de todos los productos
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    @Override
    public List<Producto> consultarTodosLosProductos() throws NegocioException {
        try {
            return productoDAO.consultarTodosLosProductos();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Realiza una búsqueda de productos basados en su tipo y un texto de búsqueda.
     *
     * @param tipo Tipo de producto a filtrar
     * @param busqueda Texto para filtrar los productos
     * @return Lista de productos que coinciden con los criterios de búsqueda
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    @Override
    public List<Producto> busquedaProducto(TipoProducto tipo, String busqueda) throws NegocioException {
        try {
            return productoDAO.busquedaProductos(tipo, busqueda);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Inhabilita un producto en el menú, cambiando su estado.
     *
     * @param idProducto ID del producto a inhabilitar
     * @return {@code true} si el producto fue inhabilitado correctamente, {@code false} si ocurrió un error
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    @Override
    public boolean inhabilitarProductoDelMenu(Long idProducto) throws NegocioException {
        try {
            return productoDAO.inhabilitarProducto(idProducto);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error: No se pudo eliminar el producto con el id: " + idProducto, e);
        }
    }

    /**
     * Habilita un producto en el menú.
     *
     * @param idProducto ID del producto a habilitar
     * @return {@code true} si el producto fue habilitado correctamente, {@code false} si ocurrió un error
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    @Override
    public boolean habilitarProductoDelMenu(Long idProducto) throws NegocioException {
        try {
            return productoDAO.habilitarProducto(idProducto);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta los ingredientes de un producto en particular.
     *
     * @param idProducto ID del producto del cual se desean obtener los ingredientes
     * @return Lista de ingredientes del producto
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    @Override
    public List<IngredienteProducto> consultarIngredientesProducto(Long idProducto) throws NegocioException {
        try {
            return productoDAO.consultarIngredientesDelProducto(idProducto);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta un producto por su ID.
     *
     * @param idProducto ID del producto a consultar
     * @return Producto correspondiente al ID proporcionado
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    @Override
    public Producto consultarProductoPorId(Long idProducto) throws NegocioException {
        try {
            return productoDAO.consultarProductoPorId(idProducto);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Modifica un producto en el menú.
     *
     * @param p DTO del producto a modificar
     * @return Producto modificado
     * @throws NegocioException Si ocurre un error durante la operación de negocio
     */
    @Override
    public Producto modificarProducto(ProductoDTO p) throws NegocioException {
        Producto producto = ProductoMapper.toEntity(p);
        List<IngredienteProducto> ingredientesProducto = producto.getIngredientes();
        
        try {
            Producto productoModificado = productoDAO.modificarProductoDelMenu(producto);
            
            for (IngredienteProductoDTO ingredienteProductoDTO : p.getIngredientes()) {
                IngredienteProducto ingredienteProducto = new IngredienteProducto(productoModificado, ingredienteProductoDTO.getIngrediente(), ingredienteProductoDTO.getCantidad());
                ingredienteProducto.setId(ingredienteProductoDTO.getId());
                ingredientesProducto.add(ingredienteProducto);
            }
            
            try {
                for (IngredienteProducto ingredienteProducto : ingredientesProducto) {
                    if (ingredienteProducto.getId() == null) {
                        ingredienteProductoDAO.asignarIngredienteAlProducto(productoModificado.getId(), ingredienteProducto.getIngrediente().getId(), ingredienteProducto.getCantidad());
                    }
                }
            } catch (PersistenciaException e) {
                throw new NegocioException(e.getMessage());
            }
            
            return productoModificado;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
}