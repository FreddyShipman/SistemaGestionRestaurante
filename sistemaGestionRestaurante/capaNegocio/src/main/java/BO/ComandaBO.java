package BO;

import DAO.MesaDAO;
import DAO.ProductoComandaDAO;
import DTOs.ComandaDTO;
import DTOs.NuevaComandaDTO;
import DTOs.ProductoComandaDTO;
import entidades.Comanda;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import enums.EstadoMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IComandaBO;
import interfaces.IComandaDAO;
import interfaces.IMesaDAO;
import interfaces.IProductoComandaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mappers.ComandaMapper;
import mappers.ProductoComandaMapper;

/**
 *
 * @author janot
 */
/**
 * Clase de negocio para la gestión de las comandas. Implementa la interfaz {@link IComandaBO}
 * y utiliza las capas de acceso a datos {@link IComandaDAO}, {@link IMesaDAO}, y {@link IProductoComandaDAO}
 * para realizar las operaciones sobre las comandas y los productos asociados.
 */
public class ComandaBO implements IComandaBO {

    /** Objeto de acceso a datos de comandas */
    private IComandaDAO comandaDAO;
    
    /** Objeto de acceso a datos de mesas */
    private IMesaDAO mesaDAO;
    
    /** Objeto de acceso a datos de productos de comanda */
    private IProductoComandaDAO productoComandaDAO;

    /**
     * Constructor para inicializar el servicio de negocio con los objetos DAO.
     *
     * @param comandaDAO Objeto DAO para realizar las consultas de comandas
     */
    public ComandaBO(IComandaDAO comandaDAO) {
        this.comandaDAO = comandaDAO;
        this.mesaDAO = MesaDAO.getInstanceDAO();
        this.productoComandaDAO = ProductoComandaDAO.getInstanceDAO();
    }

    /**
     * Crea una nueva comanda y asocia productos a ella.
     *
     * @param comandaNueva Datos de la nueva comanda a crear
     * @return Nueva comanda creada
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public NuevaComandaDTO crearComanda(NuevaComandaDTO comandaNueva) throws NegocioException {
        Comanda comanda = ComandaMapper.toEntity(comandaNueva);
        Comanda comandaCreada = null;
              
        try {
            // Crear la comanda en la base de datos
            comandaCreada = comandaDAO.crearComanda(comanda);   
            // Cambiar el estado de la mesa a "OCUPADA"
            mesaDAO.cambiarEstadoDeMesa(comandaCreada.getMesa().getId(), EstadoMesa.OCUPADA);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
        
        // Asignar productos a la comanda
        List<ProductoComandaDTO> productosComandaDTO = comandaNueva.getProductosComanda();
        List<ProductoComanda> productosComanda = new ArrayList<>();
        for (ProductoComandaDTO productoComandaDTO : productosComandaDTO) {
            ProductoComanda productoComanda = ProductoComandaMapper.toEntity(productoComandaDTO);
            productoComanda.setComanda(comandaCreada);
            productosComanda.add(productoComanda);
        }
        
        try {
            // Agregar los productos a la comanda
            for (ProductoComanda productoComanda : productosComanda) {
                productoComandaDAO.agregarProductoAcomanda(productoComanda);
            }
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
        
        return comandaNueva;
    }

    /**
     * Elimina una comanda por su ID. Método no implementado.
     *
     * @param id ID de la comanda a eliminar
     * @return {@code true} si la operación fue exitosa, de lo contrario {@code false}
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public boolean eliminarComanda(Long id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Modifica una comanda existente con nuevos datos.
     *
     * @param c Datos de la comanda a modificar
     * @return Comanda modificada
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public Comanda modificarComanda(ComandaDTO c) throws NegocioException {   
        Comanda comanda = ComandaMapper.toEntity(c);
                
        List<ProductoComanda> productosComanda = comanda.getProductos();
                
        try {
            // Actualizar la comanda en la base de datos
            Comanda comandaModificada = comandaDAO.actualizarComanda(comanda);
            
            // Asignar nuevos productos a la comanda
            for (ProductoComandaDTO productoComandaDTO : c.getProductos()) {
                ProductoComanda productoComanda = new ProductoComanda(
                    comandaModificada, 
                    productoComandaDTO.getProducto(), 
                    productoComandaDTO.getPrecioActual(),
                    productoComandaDTO.getComentario(), 
                    productoComandaDTO.getCantidad(), 
                    productoComandaDTO.getImporte()
                );
                productoComanda.setId(productoComandaDTO.getId());
                
                productosComanda.add(productoComanda);
            }
            
            try {
                // Agregar los productos a la comanda modificada
                for (ProductoComanda productoComanda : productosComanda) {
                    if (productoComanda.getId() == null) {
                        productoComandaDAO.agregarProductoAcomanda(productoComanda);
                    }
                }
            } catch (PersistenciaException e) {
                throw new NegocioException(e.getMessage());
            }
            
            return comandaModificada;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Agrega un producto a una comanda existente.
     *
     * @param productoComandaDTO Datos del producto a agregar
     * @return ProductoComanda agregado
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public ProductoComanda agregarProductoAcomanda(ProductoComandaDTO productoComandaDTO) throws NegocioException {
        ProductoComanda productoComanda = ProductoComandaMapper.toEntity(productoComandaDTO);
        
        try {
            return productoComandaDAO.agregarProductoAcomanda(productoComanda);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Busca comandas según su estado y un rango de fechas.
     *
     * @param estadoComanda Estado de la comanda
     * @param desde Fecha de inicio del rango
     * @param hasta Fecha de fin del rango
     * @return Lista de comandas que cumplen con los criterios
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public List<Comanda> buscadorComandas(EstadoComanda estadoComanda, Date desde, Date hasta) throws NegocioException {
        try {
            return comandaDAO.buscadorComandas(estadoComanda, desde, hasta);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta todas las comandas pendientes.
     *
     * @return Lista de comandas abiertas (pendientes)
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public List<Comanda> consultarComandasPendientes() throws NegocioException {
        try {
            return comandaDAO.consultarComandasPorEstado(EstadoComanda.ABIERTA);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Cancela una comanda por su ID.
     *
     * @param idComanda ID de la comanda a cancelar
     * @return Comanda cancelada
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public Comanda cancelarComanda(Long idComanda) throws NegocioException {
        try {
            return comandaDAO.cambiarEstadoComanda(idComanda, EstadoComanda.CANCELADA);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Finaliza una comanda por su ID.
     *
     * @param idComanda ID de la comanda a finalizar
     * @return Comanda finalizada
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public Comanda finalizarComanda(Long idComanda) throws NegocioException {
        try {
            return comandaDAO.cambiarEstadoComanda(idComanda, EstadoComanda.ENTREGADA);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta una comanda por su ID.
     *
     * @param idComanda ID de la comanda a consultar
     * @return Comanda solicitada
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public Comanda consultarComandaPorID(Long idComanda) throws NegocioException {
        try {
            return comandaDAO.consultarComandaPorId(idComanda);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Elimina un producto de la comanda.
     *
     * @param idProductoDeComanda ID del producto en la comanda a quitar
     * @return {@code true} si el producto fue eliminado exitosamente, {@code false} de lo contrario
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public boolean quitarProductoDecomanda(Long idProductoDeComanda) throws NegocioException {
        try {
            return productoComandaDAO.quitarProductoDecomanda(idProductoDeComanda);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta todos los productos de una comanda específica.
     *
     * @param idComanda ID de la comanda
     * @return Lista de productos en la comanda
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    @Override
    public List<ProductoComandaDTO> consultarProductosDeComanda(Long idComanda) throws NegocioException {
        List<ProductoComandaDTO> productosComandaDTO = new ArrayList<>();
        try {
            List<ProductoComanda> productosComanda = comandaDAO.consultarTodosLosProductosDeComanda(idComanda);
            
            for (ProductoComanda producto : productosComanda) {
                productosComandaDTO.add(ProductoComandaMapper.toDTO(producto));
            }
            
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
        
        return productosComandaDTO;
    }
}