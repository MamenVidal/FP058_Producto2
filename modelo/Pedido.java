package modelo;

import java.time.LocalDate;

public class Pedido {
    private int numeroPedido;
    private Cliente cliente;
    private Articulo articulo;
    private int unidadesPedido;
    private LocalDate fechaHoraPedido;
    private float totalPedido;

    public Pedido(int numeroPedido, int unidadesPedido, LocalDate fechaHoraPedido, float totalPedido,
            Cliente cliente, Articulo articulo) {
        super();
        this.numeroPedido = numeroPedido;
        this.unidadesPedido = unidadesPedido;
        this.fechaHoraPedido = fechaHoraPedido;
        this.totalPedido = totalPedido;
        this.cliente = cliente;
        this.articulo = articulo;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getUnidadesPedido() {
        return unidadesPedido;
    }

    public void setUnidadesPedido(int unidadesPedido) {
        this.unidadesPedido = unidadesPedido;
    }

    public LocalDate getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(LocalDate fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public float getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(float totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public boolean pedidoEnviado() {
        return true;
    }

    public float precioEnvio() {
        return (articulo.getGastoEnvio() * (float) unidadesPedido) * ((100 - cliente.descuentoEnv()) / 100);
    }

    public float precioTotal() {
        return (float) unidadesPedido * articulo.getPrecioVenta() + precioEnvio();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numeroPedido +
                ", cliente=" + cliente +
                ", articulo=" + articulo +
                ", cantidad=" + unidadesPedido +
                ", fechaHora=" + fechaHoraPedido +
                ", pedidoEnviado=" + pedidoEnviado() +
                ", precioEnvio=" + precioEnvio() +
                '}';
    }
}
