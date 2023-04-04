package modelo;

public class ClientePremium extends Cliente {
    private ListaPedidos listaPedidos;

    public ClientePremium(String nombre, String domicilio, String nif, String email) {
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
        return "Cliente Premium";
    }

    public float calcAnual() {
        return 30;
    }

    public float descuentoEnv() {
        return 20;
    }

}
