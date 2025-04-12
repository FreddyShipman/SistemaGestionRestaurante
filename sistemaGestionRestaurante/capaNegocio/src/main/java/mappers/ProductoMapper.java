package mappers;

import DTOs.IngredienteProductoDTO;
import DTOs.NuevoProductoDTO;
import DTOs.ProductoDTO;
import entidades.IngredienteProducto;
import entidades.Producto;
import enums.EstadoProducto;
import enums.TipoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Clase encargada de convertir entre la entidad Producto y su respectivo DTO ProductoDTO.
 */
public class ProductoMapper {

    /**
     * Convierte un DTO NuevoProductoDTO en una entidad Producto.
     * 
     * @param nuevoProductoDTO El DTO con los datos del nuevo producto.
     * @return La entidad Producto correspondiente.
     */
    public static Producto toEntity(NuevoProductoDTO nuevoProductoDTO){

        // Crear y devolver la entidad Producto a partir del DTO.
        Producto producto = new Producto(nuevoProductoDTO.getNombre(), 
                                         nuevoProductoDTO.getPrecio(), 
                                         nuevoProductoDTO.getTipoProducto(), 
                                         nuevoProductoDTO.getEstado());
        
        return producto;
    }
    
    /**
     * Convierte una entidad Producto en su respectivo DTO ProductoDTO.
     * 
     * @param producto La entidad Producto.
     * @return El DTO ProductoDTO correspondiente.
     */
    public static ProductoDTO toDTO(Producto producto){  
        List<IngredienteProductoDTO> ingredientesProducto = new ArrayList<>();
        
        // Mapea los ingredientes del producto en el DTO.
        for (IngredienteProducto ingrediente : producto.getIngredientes()) {
            ingredientesProducto.add(new IngredienteProductoDTO(ingrediente.getIngrediente(), ingrediente.getCantidad()));
        }
        
        // Devolver el DTO ProductoDTO con los datos del producto.
        return new ProductoDTO(producto.getId(),
                               producto.getNombre(), 
                               producto.getPrecio(), 
                               producto.getTipo(),
                               producto.getEstado(), 
                               ingredientesProducto);
    }
    
    /**
     * Convierte un DTO ProductoDTO en una entidad Producto.
     * 
     * @param productoDTO El DTO ProductoDTO con los datos del producto.
     * @return La entidad Producto correspondiente.
     */
    public static Producto toEntity(ProductoDTO productoDTO){

        // Crear la entidad Producto y establecer su ID.
        Producto p = new Producto(productoDTO.getNombre(), 
                                  productoDTO.getPrecio(), 
                                  productoDTO.getTipo(), 
                                  productoDTO.getEstado());
        p.setId(productoDTO.getId());
        
        return p;
    }
}