package sweetbakery.dominio;

import java.util.*;

public class Productos {
    
    private int idProducto;
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

    public Productos(TipoProducto tipoProducto, double precio, Date fechaC) {
        this();
        this.tipoProducto = tipoProducto;
        this.precio = precio;
        this.fechaC = fechaC;
    }

    public Productos(int idProducto, TipoProducto tipoProducto, double precio, Date fechaC) {
        this.idProducto = idProducto;
        this.tipoProducto = tipoProducto;
        this.precio = precio;
        this.fechaC = fechaC;
    }
    
    

    //Getter and setters

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
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
        return "Productos{" + "idProducto=" + idProducto + ", tipoProducto=" + tipoProducto + ", precio=" + precio + ", fechaC=" + fechaC + '}';
    }
    
    
}
