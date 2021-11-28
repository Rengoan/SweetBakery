package sweetbakery.dominio;

public class Empleado {
    private int idEmp;
    private String nombre;
    private String apellidos;
    private String correo;
    private String tlfEmp;
    private String Ssocial;
    private String Cbancaria;
    public Empleado() {
    }

    public Empleado(int idEmp, String nombre, String apellidos, String 
            correo, String tlfEmp, String Ssocial, String Cbancaria) {
        
        this.idEmp = idEmp;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tlfEmp = tlfEmp;
        this.Ssocial = Ssocial;
        this.Cbancaria = Cbancaria;
    }

    public Empleado(String nombre, String apellidos, String 
            correo, String tlfEmp, String Ssocial, String Cbancaria) {
        this();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tlfEmp = tlfEmp;
        this.Ssocial = Ssocial;
        this.Cbancaria = Cbancaria;
    }
    
    //Getter and Setter

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTlfEmp() {
        return tlfEmp;
    }

    public void setTlfEmp(String tlfEmp) {
        this.tlfEmp = tlfEmp;
    }

    public String getSsocial() {
        return Ssocial;
    }

    public void setSsocial(String Ssocial) {
        this.Ssocial = Ssocial;
    }

    public String getCbancaria() {
        return Cbancaria;
    }

    public void setCbancaria(String Cbancaria) {
        this.Cbancaria = Cbancaria;
    }

    
    
    
    //toString

    @Override
    public String toString() {
        return "Empleado\n========= " + "\n idEmp: " + idEmp + "\n nombre: " 
                + nombre + "\n apellidos: " + apellidos + "\n correo: " 
                + correo + "\n tlfEmp: " + tlfEmp + "\n Ssocial: " + Ssocial 
                + "\n Cbancaria: " + Cbancaria+"\n";
    }
    
    
    
    
    
}
