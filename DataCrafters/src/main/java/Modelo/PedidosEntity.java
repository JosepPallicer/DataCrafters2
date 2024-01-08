package Modelo;

import java.sql.Timestamp;
import java.util.Collection;

public class PedidosEntity {
    private int idNumeroPedido;
    private Integer idCliente;
    private Timestamp fechaHora;
    private byte enviado;
    private byte pagado;
    private Collection<DetallepedidoEntity> idPedidos;
    private ClientesEntity idClientes;

    public int getIdNumeroPedido() {
        return idNumeroPedido;
    }

    public void setIdNumeroPedido(int idNumeroPedido) {
        this.idNumeroPedido = idNumeroPedido;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public byte getEnviado() {
        return enviado;
    }

    public void setEnviado(byte enviado) {
        this.enviado = enviado;
    }

    public byte getPagado() {
        return pagado;
    }

    public void setPagado(byte pagado) {
        this.pagado = pagado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidosEntity that = (PedidosEntity) o;

        if (idNumeroPedido != that.idNumeroPedido) return false;
        if (enviado != that.enviado) return false;
        if (pagado != that.pagado) return false;
        if (idCliente != null ? !idCliente.equals(that.idCliente) : that.idCliente != null) return false;
        if (fechaHora != null ? !fechaHora.equals(that.fechaHora) : that.fechaHora != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNumeroPedido;
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        result = 31 * result + (fechaHora != null ? fechaHora.hashCode() : 0);
        result = 31 * result + (int) enviado;
        result = 31 * result + (int) pagado;
        return result;
    }

    public Collection<DetallepedidoEntity> getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Collection<DetallepedidoEntity> idPedidos) {
        this.idPedidos = idPedidos;
    }

    public ClientesEntity getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(ClientesEntity idClientes) {
        this.idClientes = idClientes;
    }

    public void setIdArticulo(int idCodigo) {
    }

    public void setCantidad(int cantidad) {
    }
}
