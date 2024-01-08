package Modelo;

import java.math.BigDecimal;
import java.util.Collection;

public class TipoclientesEntity {
    private String tipo;
    private BigDecimal cuotaAnual;
    private BigDecimal descuentoEnvio;
    private Collection<ClientesEntity> clientesTipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getCuotaAnual() {
        return cuotaAnual;
    }

    public void setCuotaAnual(BigDecimal cuotaAnual) {
        this.cuotaAnual = cuotaAnual;
    }

    public BigDecimal getDescuentoEnvio() {
        return descuentoEnvio;
    }

    public void setDescuentoEnvio(BigDecimal descuentoEnvio) {
        this.descuentoEnvio = descuentoEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoclientesEntity that = (TipoclientesEntity) o;

        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (cuotaAnual != null ? !cuotaAnual.equals(that.cuotaAnual) : that.cuotaAnual != null) return false;
        if (descuentoEnvio != null ? !descuentoEnvio.equals(that.descuentoEnvio) : that.descuentoEnvio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tipo != null ? tipo.hashCode() : 0;
        result = 31 * result + (cuotaAnual != null ? cuotaAnual.hashCode() : 0);
        result = 31 * result + (descuentoEnvio != null ? descuentoEnvio.hashCode() : 0);
        return result;
    }

    public Collection<ClientesEntity> getClientesTipo() {
        return clientesTipo;
    }

    public void setClientesTipo(Collection<ClientesEntity> clientesTipo) {
        this.clientesTipo = clientesTipo;
    }
}
