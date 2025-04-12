package mappers;

import DTOs.IngredienteProductoDTO;
import entidades.IngredienteProducto;

/**
 *
 * @author janot
 */
/**
 * Clase encargada de convertir entre la entidad IngredienteProducto y su respectivo DTO IngredienteProductoDTO.
 */
public class IngredienteProductoMapper {

    /**
     * Convierte un DTO IngredienteProductoDTO en una entidad IngredienteProducto.
     * 
     * @param ingredienteProductoDTO El DTO con los datos de IngredienteProducto.
     * @return La entidad IngredienteProducto correspondiente.
     */
    public static IngredienteProducto toEntity(IngredienteProductoDTO ingredienteProductoDTO){
        // El ID es nulo, ya que estamos creando una nueva entidad.
        return new IngredienteProducto(null, ingredienteProductoDTO.getIngrediente(), ingredienteProductoDTO.getCantidad());
    }

    /**
     * Convierte una entidad IngredienteProducto a su respectivo DTO IngredienteProductoDTO.
     * 
     * @param ingredienteProducto La entidad IngredienteProducto.
     * @return El DTO IngredienteProductoDTO correspondiente.
     */
    public static IngredienteProductoDTO toDTO(IngredienteProducto ingredienteProducto){
        // Convertir la entidad a un DTO y mapear los campos.
        IngredienteProductoDTO ingredienteProductoDTO = new IngredienteProductoDTO(ingredienteProducto.getIngrediente(), ingredienteProducto.getCantidad());
        // Establecer el ID en el DTO.
        ingredienteProductoDTO.setId(ingredienteProducto.getId());
        return ingredienteProductoDTO;  
    }
}