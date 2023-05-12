package stream;

public class Persona {
    private String p_nombre;
    private String p_apellido;
    private String s_apellido;

    public Persona() {
    }

    public Persona(String p_nombre, String p_apellido, String s_apellido) {
        this.p_nombre = p_nombre;
        this.p_apellido = p_apellido;
        this.s_apellido = s_apellido;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public String getP_apellido() {
        return p_apellido;
    }

    public void setP_apellido(String p_apellido) {
        this.p_apellido = p_apellido;
    }

    public String getS_apellido() {
        return s_apellido;
    }

    public void setS_apellido(String s_apellido) {
        this.s_apellido = s_apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "p_nombre=" + p_nombre + ", p_apellido=" + p_apellido + ", s_apellido=" + s_apellido + '}';
    }
}
