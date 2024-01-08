package Modelo;

import java.io.Serializable;

public class DetallepedidoEntityPK implements Serializable {
    private int idNumeroPedido;
    private int idCodigo;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetallepedidoEntityPK that = (DetallepedidoEntityPK) o;

        if (idNumeroPedido != that.idNumeroPedido) return false;
        if (idCodigo != that.idCodigo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNumeroPedido;
        result = 31 * result + idCodigo;
        return result;
    }
}
