package modelo;

public class Articulo {
    private String codigo;
    private String descripcion;
    private float precioVenta;
    private float gastoEnvio;
    private int tiempo;

    public Articulo(String codigo, String descripcion, float precioVenta, float gastoEnvio, int tiempo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.gastoEnvio = gastoEnvio;
        this.tiempo = tiempo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getGastoEnvio() {
        return gastoEnvio;
    }

    public void setGastoEnvio(float gastoEnvio) {
        this.gastoEnvio = gastoEnvio;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioVenta=" + precioVenta +
                ", gastoEnvio=" + gastoEnvio +
                ", tiempo=" + tiempo +
                '}';
    }
}
