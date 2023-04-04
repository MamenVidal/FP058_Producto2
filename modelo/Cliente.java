package modelo;

public abstract class Cliente {
    private String nombre;
    private String domicilio;
    private String nif;
    private String email;

    public Cliente(String nombre, String domicilio, String nif, String email) {
        super();
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String tipoCliente();

    public abstract float calcAnual();

    public abstract float descuentoEnv();

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", domicilio=" + domicilio + ", nif=" + nif + ", email=" + email
                + ", tipoCliente()=" + tipoCliente() + ", calcAnual()=" + calcAnual() + ", descuentoEnv()="
                + descuentoEnv() + "]";
    }
}
