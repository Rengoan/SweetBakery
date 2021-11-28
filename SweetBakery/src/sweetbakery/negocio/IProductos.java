package sweetbakery.negocio;

import java.util.Date;
import sweetbakery.dominio.TipoProducto;


public interface IProductos {
    
    // Agrega un producto al archivo
    void agregarProducto(int idProducto,String nombre,String descrip, TipoProducto producto,Double precio, Date fechaC, String nombreCatalogoP);
    
    // Mostrar todas los productos del catálogo
    void listarProductos(String nombreCatalogoP);
    
    // Busca el producto "Buscar" en nuestro catálogo
    void buscarProducto(String nombreCatalogoP, String buscar);
    
    void buscarProductoId(String nombreCatalogoP, int buscar);
    
    // Nos inicia nuestro catálogo
    void iniciarCatalogoP(String nombreCatalogoP);
    
    void borrarP(String nombreCatalogoP, String nombreProducto);
    
    String borrarCatalogoP(String nombreCatalogoP);
    
}
