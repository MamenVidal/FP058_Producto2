package modelo;

public class ListaClientes extends Lista<Cliente> {

    public String addCliente(String nombre, String domicilio, String nif, String email, String tipoCliente) {
        try {
            Cliente cliente;
            if (tipoCliente.equals("Premium")) {
                cliente = new ClientePremium(nombre, domicilio, nif, email);
            } else {
                cliente = new ClienteEstandar(nombre, domicilio, nif, email);
            }
            this.lista.add(cliente);
            return "El cliente ha sido añadido correctamente: " + cliente.getNombre();
        } catch (Exception e) {
            return "El cliente no ha podido ser introducido correctamente";
        }
    }

    public Cliente buscarPorNIF(String nif) {
        for (Cliente Cliente : lista) {
            if (Cliente.getNif().equals(nif)) {
                return Cliente;
            }
        }
        return null;
    }

    public String borrarCliente(String nif) {
        Cliente cliente = buscarPorNIF(nif);
        if (cliente != null) {
            lista.remove(cliente);
            return "El cliente ha sido borrado correctamente";
        } else {
            return "El cliente no ha podido ser borrado";
        }
    }
}
