package sweetbakery.dominio;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String tlf;
    private static int contador=0;
    
    //Constructor

    public Cliente(int id) {
        this.id = Cliente.contador++;
    }

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido, String correo, String tlf) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tlf = tlf;
    }
    
    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Cliente.contador = contador;
    }
    
    //toString 

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", tlf=" + tlf + '}';
    }
    
    
    
    
    
}
