package DTOs;

import entidades.Cliente;
import entidades.Mesa;
import enums.EstadoComanda;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Clase DTO que representa una comanda en el sistema,
 * incluyendo información del cliente, mesa, productos y estado.
 */
public class ComandaDTO {
    
    /** Identificador único de la comanda */
    private Long id;

    /** Folio o número de referencia de la comanda */
    private String folio;

    /** Fecha en la que se generó la comanda */
    private Date fechaComanda;

    /** Estado actual de la comanda */
    private EstadoComanda estado;

    /** Total monetario de la comanda */
    private double total;

    /** Cliente asociado a la comanda */
    private Cliente cliente;

    /** Mesa en la que se registró la comanda */
    private Mesa mesa;

    /** Lista de productos incluidos en la comanda */
    private List<ProductoComandaDTO> productos;

    /**
     * Constructor con todos los atributos de la comanda.
     *
     * @param id Identificador único de la comanda
     * @param folio Folio o referencia de la comanda
     * @param fechaComanda Fecha en que se generó la comanda
     * @param estado Estado actual de la comanda
     * @param total Total de la comanda
     * @param cliente Cliente asociado
     * @param mesa Mesa asignada
     * @param productos Lista de productos de la comanda
     */
    public ComandaDTO(Long id, String folio, Date fechaComanda, EstadoComanda estado, double total, Cliente cliente, Mesa mesa, List<ProductoComandaDTO> productos) {
        this.id = id;
        this.folio = folio;
        this.fechaComanda = fechaComanda;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
        this.mesa = mesa;
        this.productos = productos;
    }

    /**
     * Obtiene el identificador de la comanda.
     *
     * @return ID de la comanda
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la comanda.
     *
     * @param id Nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el folio de la comanda.
     *
     * @return Folio de la comanda
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Establece el folio de la comanda.
     *
     * @param folio Nuevo folio
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Obtiene la fecha de la comanda.
     *
     * @return Fecha de creación de la comanda
     */
    public Date getFechaComanda() {
        return fechaComanda;
    }

    /**
     * Establece la fecha de la comanda.
     *
     * @param fechaComanda Nueva fecha
     */
    public void setFechaComanda(Date fechaComanda) {
        this.fechaComanda = fechaComanda;
    }

    /**
     * Obtiene el estado de la comanda.
     *
     * @return Estado actual
     */
    public EstadoComanda getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la comanda.
     *
     * @param estado Nuevo estado
     */
    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el total de la comanda.
     *
     * @return Total monetario
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de la comanda.
     *
     * @param total Nuevo total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Obtiene el cliente de la comanda.
     *
     * @return Cliente asociado
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente de la comanda.
     *
     * @param cliente Nuevo cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la mesa asignada a la comanda.
     *
     * @return Mesa asociada
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Establece la mesa de la comanda.
     *
     * @param mesa Nueva mesa
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * Obtiene la lista de productos en la comanda.
     *
     * @return Lista de productos
     */
    public List<ProductoComandaDTO> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de productos de la comanda.
     *
     * @param productos Nuevos productos
     */
    public void setProductos(List<ProductoComandaDTO> productos) {
        this.productos = productos;
    }
}