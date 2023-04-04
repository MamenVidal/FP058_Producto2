package modelo;

public class ClienteEstandar extends Cliente {
    private ListaPedidos listaPedidos;

    public ClienteEstandar(String nombre, String domicilio, String nif, String email) {
        super(nombre, domicilio, nif, email);
        listaPedidos = new ListaPedidos();
    }

    public ListaPedidos getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ListaPedidos listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public String tipoCliente() {
        return "Cliente Estandar";
    }

    public float calcAnual() {
        return 0;
    }

    public float descuentoEnv() {
        return 0;
    }

}
