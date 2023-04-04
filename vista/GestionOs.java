package vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import controlador.Controlador;
import modelo.Articulo;
import modelo.Cliente;

import modelo.Pedido;

public class GestionOs {
    private Controlador controlador;
    private Scanner teclado;

    public GestionOs() {
        controlador = new Controlador();
        teclado = new Scanner(System.in);
    }

    public void inicio() {
        boolean salir = false;
        char opcion;

        do {
            System.out.println("1. Gestión Artículos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcion = pedirOpcion();
            switch (opcion) {
                case '1':
                    gestionArticulos();
                    break;
                case '2':
                    gestionClientes();
                    break;
                case '3':
                    gestionPedidos();
                    break;
                case '0':
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (!salir);
    }

    private char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0):");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    private void gestionArticulos() {
        char opcion;
        do {
            System.out.println("1. Agregar artículo");
            System.out.println("2. Mostrar lista de artículos");
            System.out.println("0. Volver");
            opcion = pedirOpcion();
            switch (opcion) {
                case '1':
                    System.out.println("Introduce los datos del artículo:");
                    System.out.print("Código: ");
                    String codigo = teclado.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = teclado.nextLine();
                    System.out.print("Precio de venta: ");
                    float precioVenta = Float.parseFloat(teclado.nextLine());
                    System.out.print("Gasto de envío: ");
                    float gastoEnvio = Float.parseFloat(teclado.nextLine());
                    System.out.print("Tiempo de entrega: ");
                    int tiempo = Integer.parseInt(teclado.nextLine());
                    controlador.addArticulo(codigo, descripcion, precioVenta, gastoEnvio, tiempo);
                    break;
                case '2':
                    System.out.println("Lista de artículos:");
                    controlador.getListaArticulos();
                    break;
                case '0':
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != '0');
    }

    private void gestionClientes() {
        char opcion;
        do {
            System.out.println("1. Agregar cliente");
            System.out.println("2. Mostrar lista de clientes por tipo");
            System.out.println("3. Mostrar todos los clientes");
            System.out.println("0. Volver");
            opcion = pedirOpcion();
            switch (opcion) {
                case '1':
                    System.out.println("Introduce los datos del cliente:");
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Dirección: ");
                    String domicilio = teclado.nextLine();
                    System.out.print("nif: ");
                    String nif = teclado.nextLine();
                    System.out.print("email: ");
                    String email = teclado.nextLine();
                    System.out.print("Tipo de cliente (Premium o Estandar): ");
                    String tipoCliente = teclado.nextLine();
                    controlador.addCliente(nombre, domicilio, nif, email, tipoCliente);
                    break;
                case '2':
                    System.out.println("Que tipo de cliente quieres ver? (Premium o Estandar)");
                    String tipo = teclado.nextLine();
                    System.out.println("Lista de clientes:");
                    controlador.getListaClientes(tipo);
                    break;
                case '3':
                    System.out.println("Lista de clientes:");
                    controlador.getListaClientesTodos();
                    break;
                case '0':
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != '0');
    }

    private void gestionPedidos() {
        char opcion;
        do {
            System.out.println("1. Agregar pedido");
            System.out.println("2. Mostrar lista de pedidos");
            System.out.println("3. Eliminar pedido");
            System.out.println("4. Añadir un pedido a otro cliente");
            System.out.println("0. Volver");
            opcion = pedirOpcion();
            switch (opcion) {
                case '1':
                    System.out.println("Introduce los datos del pedido:");
                    System.out.print("numero de Pedido: ");
                    int numeroPedido = Integer.parseInt(teclado.nextLine());
                    if (controlador.existeNumeroPedido(numeroPedido)) {
                        System.out.println("El pedido ya existe");
                        break;
                    }
                    System.out.print("Unidades: ");
                    int unidadesPedido = Integer.parseInt(teclado.nextLine());
                    System.out.print("Fecha ejemplo(2020-12-31): ");
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate fechaHoraPedido = LocalDate.parse(teclado.nextLine(), formato);
                    System.out.print("Total: ");
                    float totalPedido = Float.parseFloat(teclado.nextLine());
                    System.out.print("Nif del Cliente: ");
                    String nif = teclado.nextLine();
                    Cliente cliente = controlador.buscarPorNIF(nif);
                    if (cliente == null) {
                        System.out.println("El cliente no existe");
                        break;
                    }
                    System.out.print("Codigo del Articulo: ");
                    String codigo = teclado.nextLine();
                    Articulo articulo = controlador.buscarPorCodigo(codigo);
                    if (articulo == null) {
                        System.out.println("El articulo no existe");
                        break;
                    }
                    controlador.addPedido(numeroPedido, unidadesPedido, fechaHoraPedido, totalPedido, cliente,
                            articulo);
                    break;
                case '2':
                    System.out.println("Lista de pedidos:");
                    controlador.getListaPedidos();
                    break;
                case '3':
                    System.out.println("Introduce el numero de pedido a eliminar:");
                    int numero = Integer.parseInt(teclado.nextLine());
                    controlador.borrarPedido(numero);
                    break;
                case '4':
                    System.out.println("Introduce el nif del cliente:");
                    String nifCliente = teclado.nextLine();
                    Cliente clientePedido = controlador.buscarPorNIF(nifCliente);
                    if (clientePedido == null) {
                        System.out.println("El cliente no existe");
                        break;
                    }
                    System.out.println("Introduce el numero de pedido:");
                    int numeroPedidoCliente = Integer.parseInt(teclado.nextLine());
                    Pedido pedidoCliente = controlador.buscarPorNumeroPedido(numeroPedidoCliente);
                    if (pedidoCliente == null) {
                        System.out.println("El pedido no existe");
                        break;
                    }
                    controlador.addPedidoACliente(pedidoCliente, clientePedido);
                    break;
                case '0':
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != '0');
    }

}
