package modelo;

import java.util.ArrayList;
import java.time.LocalDate;

public class ListaPedidos extends Lista<Pedido> {

    public String addPedido(int numeroPedido, int unidadesPedido, LocalDate fechaHoraPedido, float totalPedido,
            Cliente cliente, Articulo articulo) {
        Pedido pedidoExistente = buscarPorNumero(numeroPedido);
        if (pedidoExistente != null) {
            return "El pedido ya ha sido agregado anteriormente.";
        } else {
            Pedido pedido = new Pedido(numeroPedido, unidadesPedido, fechaHoraPedido, totalPedido,
                    cliente, articulo);
            this.lista.add(pedido);
            return "El pedido ha sido agregado correctamente.";
        }
    }

    public Pedido buscarPorNumero(int numeroPedido) {
        for (Pedido pedido : lista) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }

    public Pedido buscarPorNumeroPedido(int numeroPedido) {
        for (Pedido pedido : lista) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }

    public Pedido existeNumeroPedido(Integer numeroPedido) {
        for (Pedido pedido : lista) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }

    public ArrayList<Pedido> buscarPorCliente(Cliente cliente) {
        ArrayList<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido pedido : lista) {
            if (pedido.getCliente().equals(cliente)) {
                pedidosCliente.add(pedido);
            }
        }
        return pedidosCliente;
    }

    public float calcularTotalPedidos() {
        float total = 0;
        for (Pedido pedido : lista) {
            total += pedido.getTotalPedido();
        }
        return total;
    }

    public String borrarPedido(int numeroPedido) {
        Pedido pedido = buscarPorNumero(numeroPedido);
        if (pedido != null) {
            lista.remove(pedido);
            return "El pedido ha sido borrado correctamente.";
        } else {
            return "El pedido no ha podido ser borrado.";
        }
    }
}
