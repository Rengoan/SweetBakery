package sweetbakery.dominio;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private String tlf;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String correo, String tlf) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tlf = tlf;
    }

    

    public Cliente(String nombre, String apellido, String correo, String tlf) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tlf = tlf;
    }

 
    
    
    
    //Getter and Setter

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int id) {
        this.idCliente = idCliente;
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

    //toString 

    @Override
    public String toString() {
        return "Cliente\n========" + "\nid: " + idCliente + "\nnombre: " + nombre 
                + "\napellido: " + apellido + "\ncorreo: " + correo + "\ntlf: " + tlf + "\n";
    }
    
    
    
    
    
}
