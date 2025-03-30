package entidades;

import enums.EstadoComanda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * Entidad que representa una comanda en el sistema.
 * Una comanda es una orden realizada por un cliente e incluye
 * información sobre productos, estado y fecha de la orden.
 * 
 * @author janot
 */
@Entity
public class Comanda implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** 
     * Identificador único de la comanda 
     */
    @Id
    @Column(name = "folio", nullable = false, length = 20)
    private String folio;
    
    /** 
     * Fecha en la que se creó la comanda 
     */
    @Column(name = "fechaComanda", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaComanda;
    
    /** 
     * Estado actual de la comanda 
     */
    @Column(name = "estado", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EstadoComanda estado;

    /** 
     * Total a pagar por la comanda 
     */
    @Column(name = "total", nullable = false)
    private double total;
    
    /** 
     * Cliente asociado a la comanda 
     * Relacion muchos a uno, bidireccional, esta clase es la dueña 
     * de la relacion
     */
    @ManyToOne()
    @JoinColumn(name = "telefono", nullable = true)
    private Cliente cliente;
    
    /** 
     * Lista de productos incluidos en la comanda
     * Relacion uno a muchos, bidireccional, la entidad ProductoComanda 
     * es la dueña de la relacion.
     */
    @OneToMany(mappedBy = "comanda", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private List<ProductoComanda> productos = new ArrayList<>();
    
    /**
     * Constructor por defecto.
     */
    public Comanda() {
    }

    /**
     * Constructor que inicializa todos los atributos de la comanda.
     * 
     * @param folio Identificador único de la comanda.
     * @param fechaComanda Fecha en la que se creó la comanda.
     * @param estado Estado actual de la comanda.
     * @param total Monto total de la comanda.
     * @param cliente Cliente que realizó la comanda.
     */
    public Comanda(String folio, Date fechaComanda, EstadoComanda estado, double total, Cliente cliente) {
        this.folio = folio;
        this.fechaComanda = fechaComanda;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFechaComanda() {
        return fechaComanda;
    }

    public void setFechaComanda(Date fechaComanda) {
        this.fechaComanda = fechaComanda;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProductoComanda> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoComanda> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Comanda{" + "folio=" + folio + ", fechaComanda=" + fechaComanda + ", estado=" + estado + ", total=" + total + '}';
    }
}
