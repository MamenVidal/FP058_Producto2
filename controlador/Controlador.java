package controlador;

import modelo.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class Controlador {
    private Datos datos;

    public Controlador() {
        datos = new Datos();
    }

    public void addArticulo(String codigo, String descripcion, float precioVenta, float gastoEnvio, int tiempo) {
        Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastoEnvio, tiempo);
        datos.getListaArticulos().add(articulo);
    }

    public void addCliente(String nombre, String domicilio, String nif, String email, String tipoCliente) {
        if (tipoCliente.equals("Estandar")) {
            Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);
            datos.getListaClientes().add(cliente);
        } else if (tipoCliente.equals("Premium")) {
            Cliente cliente = new ClientePremium(nombre, domicilio, nif, email);
            datos.getListaClientes().add(cliente);
        }
    }

    public String addPedido(int numeroPedido, int unidadesPedido, LocalDate fechaHoraPedido, float totalPedido,
            Cliente cliente, Articulo articulo) {
        return datos.getListaPedidos().addPedido(numeroPedido, unidadesPedido, fechaHoraPedido, totalPedido, cliente,
                articulo);
    }

    public Articulo buscarPorCodigo(String codigo) {
        return datos.getListaArticulos().buscarPorCodigo(codigo);
    }

    public Cliente buscarPorNIF(String nif) {
        return datos.getListaClientes().buscarPorNIF(nif);
    }

    public Pedido buscarPorNumeroPedido(int numeroPedido) {
        return datos.getListaPedidos().buscarPorNumeroPedido(numeroPedido);
    }

    public Boolean existeNumeroPedido(Integer numeroPedido) {
        if (datos.getListaPedidos().existeNumeroPedido(numeroPedido) == null) {
            return false;
        }
        return true;
    }

    public String borrarPedido(int numeroPedido) {
        return datos.getListaPedidos().borrarPedido(numeroPedido);
    }

    public float calcularTotalPedidos() {
        return datos.getListaPedidos().calcularTotalPedidos();
    }

    public void getListaArticulos() {
        ArrayList<Articulo> articulos = datos.getListaArticulos().getArrayList();
        for (int i = 0; i < articulos.size(); i++) {
            System.out.println(articulos.get(i).toString());
        }
    }

    public void getListaClientes(String tipo) {
        ArrayList<Cliente> cliente = datos.getListaClientes().getArrayList();
        if (cliente.size() == 0) {
            System.out.println("No hay clientes");
        }
        if (tipo.equals("Estandar")) {
            for (int i = 0; i < cliente.size(); i++) {
                if (cliente.get(i) instanceof ClienteEstandar) {
                    System.out.println(cliente.get(i).toString());
                }
            }
        } else if (tipo.equals("Premium")) {
            for (int i = 0; i < cliente.size(); i++) {
                if (cliente.get(i) instanceof ClientePremium) {
                    System.out.println(cliente.get(i).toString());
                }
            }
        }
    }

    public void getListaClientesTodos() {
        ArrayList<Cliente> cliente = datos.getListaClientes().getArrayList();
        if (cliente.size() == 0) {
            System.out.println("No hay clientes");
        }
        for (int i = 0; i < cliente.size(); i++) {
            System.out.println(cliente.get(i).toString());
        }
    }

    public void getListaPedidos() {
        ArrayList<Pedido> pedidos = datos.getListaPedidos().getArrayList();
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println(pedidos.get(i).toString());
        }
    }

    public void addPedidoACliente(Pedido pedido, Cliente cliente) {
        if (cliente instanceof ClienteEstandar) {
            ((ClienteEstandar) cliente).getListaPedidos().add(pedido);
        } else if (cliente instanceof ClientePremium) {
            ((ClientePremium) cliente).getListaPedidos().add(pedido);
        }
    }
}
