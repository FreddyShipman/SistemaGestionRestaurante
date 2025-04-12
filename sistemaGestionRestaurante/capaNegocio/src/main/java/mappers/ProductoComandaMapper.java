package mappers;

import DTOs.ProductoComandaDTO;
import entidades.ProductoComanda;

/**
 *
 * @author janot
 */
/**
 * Clase encargada de convertir entre la entidad ProductoComanda y su respectivo DTO ProductoComandaDTO.
 */
public class ProductoComandaMapper {

    /**
     * Convierte un DTO ProductoComandaDTO en una entidad ProductoComanda.
     * 
     * @param productoComandaDTO El DTO con los datos de ProductoComanda.
     * @return La entidad ProductoComanda correspondiente.
     */
    public static ProductoComanda toEntity(ProductoComandaDTO productoComandaDTO){
        // Convertir el DTO a la entidad ProductoComanda.
        return new ProductoComanda(null, productoComandaDTO.getProducto(), productoComandaDTO.getPrecioActual(), 
                                   productoComandaDTO.getComentario(), productoComandaDTO.getCantidad(), productoComandaDTO.getImporte());
    }
    
    /**
     * Convierte una entidad ProductoComanda a su respectivo DTO ProductoComandaDTO.
     * 
     * @param productoComanda La entidad ProductoComanda.
     * @return El DTO ProductoComandaDTO correspondiente.
     */
    public static ProductoComandaDTO toDTO(ProductoComanda productoComanda){
        // Crear el DTO ProductoComandaDTO y mapear los campos desde la entidad.
        ProductoComandaDTO productoComandaDTO = new ProductoComandaDTO(productoComanda.getProducto(), productoComanda.getPrecioActual(), 
                                                                      productoComanda.getComentario(), (int) productoComanda.getCantidad(), productoComanda.getImporte());
        // Establecer el ID en el DTO.
        productoComandaDTO.setId(productoComanda.getId());
        return productoComandaDTO;
    }
}