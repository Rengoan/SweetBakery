package sweetbakery.dominio;

import java.util.*;

public class Productos {

    private int idProducto;
    private String nombreProducto;
    private String descripcion;
    private TipoProducto tipoProducto;
    private double precio;
    private Date fechaC;

    private static int contador = 1;

    //Constructores
    public Productos(int NumPedido) {
        this.idProducto = Productos.contador++;
    }

    public Productos() {
    }

    public Productos(int idProducto, String nombreProducto, String descripcion, TipoProducto tipoProducto, double precio, Date fechaC) {
        this();
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.tipoProducto = tipoProducto;
        this.precio = precio;
        this.fechaC = fechaC;
    }

    public Productos(String nombreProducto, String descripcion, TipoProducto tipoProducto, double precio, Date fechaC) {
        this();
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.tipoProducto = tipoProducto;
        this.precio = precio;
        this.fechaC = fechaC;
    }

   

    

    

//Getter and setters

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaC() {
        return fechaC;
    }

    public void setFechaC(Date fechaC) {
        this.fechaC = fechaC;
    }

    public static int getContador() {
        return contador;
    }

    
    public static void setContador(int contador) {
        Productos.contador = contador;
    }

    //toString

    @Override
    public String toString() {
        return "Productos{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcion=" + descripcion + ", tipoProducto=" + tipoProducto + ", precio=" + precio + ", fechaC=" + fechaC + '}';
    }
    

}
