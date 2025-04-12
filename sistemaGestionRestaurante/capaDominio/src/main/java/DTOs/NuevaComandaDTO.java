package DTOs;

import entidades.Cliente;
import entidades.Comanda;
import entidades.Mesa;
import enums.EstadoComanda;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
/**
 * Clase DTO utilizada para crear una nueva comanda,
 * incluyendo información del cliente, mesa, productos y total.
 */
public class NuevaComandaDTO {

    /** Objeto comanda generado (opcionalmente asignado después) */
    private Comanda comanda;

    /** Total monetario de la comanda */
    private double total;

    /** Cliente que realizó la comanda */
    private Cliente Cliente;

    /** Mesa en la que se generó la comanda */
    private Mesa mesa;

    /** Lista de productos que componen la comanda */
    private List<ProductoComandaDTO> productosComanda;

    /**
     * Constructor para inicializar una nueva comanda sin ID asignado.
     *
     * @param total Total de la comanda
     * @param Cliente Cliente que realiza la comanda
     * @param mesa Mesa en la que se realiza la comanda
     * @param productosComanda Lista de productos que conforman la comanda
     */
    public NuevaComandaDTO(double total, Cliente Cliente, Mesa mesa, List<ProductoComandaDTO> productosComanda) {
        this.total = total;
        this.Cliente = Cliente;
        this.mesa = mesa;
        this.productosComanda = productosComanda;
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
     * Obtiene el cliente que realizó la comanda.
     *
     * @return Cliente asociado
     */
    public Cliente getCliente() {
        return Cliente;
    }

    /**
     * Obtiene la mesa asignada a la comanda.
     *
     * @return Mesa donde se realizó la comanda
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Obtiene la lista de productos de la comanda.
     *
     * @return Lista de productos
     */
    public List<ProductoComandaDTO> getProductosComanda() {
        return productosComanda;
    }

    /**
     * Obtiene el objeto comanda generado.
     *
     * @return Comanda asociada
     */
    public Comanda getComanda() {
        return comanda;
    }

    /**
     * Asigna el objeto comanda generado.
     *
     * @param comanda Comanda a asignar
     */
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
}