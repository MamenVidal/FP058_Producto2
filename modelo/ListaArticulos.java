package modelo;

public class ListaArticulos extends Lista<Articulo> {

    public String addArticulo(String codigo, String descripcion, float precioVenta, float gastosEnvio,
            int tiempoPreparacion) {
        try {
            Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
            this.lista.add(articulo);
            return "El articulo ha sido añadido correctamente: " + articulo.getDescripcion();
        } catch (Exception e) {
            return "El articulo no ha podido introducirse correctamente";
        }
    }

    // Métodos adicionales específicos para la lista de Articulos
    public Articulo buscarPorCodigo(String codigo) {
        for (Articulo a : lista) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }
        return null;
    }
}
