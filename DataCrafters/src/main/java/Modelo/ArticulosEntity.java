package Modelo;

import java.math.BigDecimal;

public class ArticulosEntity {
    private int idCodigo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer tiempoPreparacion;
    private BigDecimal gastosEnvio;

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public BigDecimal getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(BigDecimal gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticulosEntity that = (ArticulosEntity) o;

        if (idCodigo != that.idCodigo) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;
        if (tiempoPreparacion != null ? !tiempoPreparacion.equals(that.tiempoPreparacion) : that.tiempoPreparacion != null)
            return false;
        if (gastosEnvio != null ? !gastosEnvio.equals(that.gastosEnvio) : that.gastosEnvio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCodigo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (tiempoPreparacion != null ? tiempoPreparacion.hashCode() : 0);
        result = 31 * result + (gastosEnvio != null ? gastosEnvio.hashCode() : 0);
        return result;
    }
}
