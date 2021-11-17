package sweetbakery.dominio;

import java.util.*;

public class Productos {
    private double precio;
    private TipoProducto tipoProducto;
    private int NumPedido;
    private Date fechaP;
    private static int contador;

    
    //Constructores
    public Productos(int NumPedido) {
        this.NumPedido = Productos.contador++;
    }

    public Productos() {
    }

    public Productos(double precio, TipoProducto tipoProducto, int NumPedido, Date fechaP) {
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.NumPedido = NumPedido;
        this.fechaP = fechaP;
    }

    
    
    
    //Getter and setter

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }


    public int getNumPedido() {
        return NumPedido;
    }

    public void setNumPedido(int NumPedido) {
        this.NumPedido = NumPedido;
    }

    public Date getFechaP() {
        return fechaP;
    }

    public void setFechaP(Date fechaP) {
        this.fechaP = fechaP;
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
        return "Productos{" + "precio=" + precio + ", tipoProducto=" + tipoProducto + ", NumPedido=" + NumPedido + ", fechaP=" + fechaP + '}';
    }

    
    
    
    
    
    
}
