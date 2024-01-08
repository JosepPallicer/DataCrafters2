package Modelo;

import java.math.BigDecimal;

public class DetallepedidoEntity {
    private int idNumeroPedido;
    private int idCodigo;
    private BigDecimal cantidad;
    private BigDecimal precio;
    private ArticulosEntity codigoArticulos;

    public int getIdNumeroPedido() {
        return idNumeroPedido;
    }

    public void setIdNumeroPedido(int idNumeroPedido) {
        this.idNumeroPedido = idNumeroPedido;
    }

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetallepedidoEntity that = (DetallepedidoEntity) o;

        if (idNumeroPedido != that.idNumeroPedido) return false;
        if (idCodigo != that.idCodigo) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNumeroPedido;
        result = 31 * result + idCodigo;
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        return result;
    }

    public ArticulosEntity getCodigoArticulos() {
        return codigoArticulos;
    }

    public void setCodigoArticulos(ArticulosEntity codigoArticulos) {
        this.codigoArticulos = codigoArticulos;
    }
}
