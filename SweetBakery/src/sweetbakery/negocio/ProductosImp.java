package sweetbakery.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sweetbakery.datos.AccesoDatosImp;
import sweetbakery.datos.IAccesoDatos;
import sweetbakery.dominio.Productos;
import sweetbakery.dominio.TipoProducto;
import sweetbakery.excepciones.AccesoDatosEx;
import sweetbakery.excepciones.EscrituraDatosEx;
import sweetbakery.excepciones.LecturaDatosEx;

public class ProductosImp implements IProductos {
    
    private final IAccesoDatos datos;

    public ProductosImp( ) {
        this.datos= new AccesoDatosImp();
    }
    
    

    @Override
    public void agregarProducto(int idProducto,String nombre,String descrip, TipoProducto producto,Double precio, Date fechaC, String nombreCatalogoP) {
        
        try {
            if (this.datos.existeP(nombreCatalogoP)) {
                this.datos.agregarP(new Productos( idProducto, nombreCatalogoP, descrip, producto, 0, fechaC), nombreCatalogoP);
            } else {
                System.out.println("Catálogo de productos no inicilizado");
            }
        } catch (EscrituraDatosEx ex) {
            System.out.println("Error al escribir en el catálogo de productos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarProductos(String nombreCatalogoP) {
        List<Productos> productos = new ArrayList<>();

        try {
            productos = this.datos.ListarP(nombreCatalogoP);
            productos.forEach(producto -> {
                System.out.println(producto.getIdProducto()+"; "+producto.getNombreProducto()+"; "+
                        producto.getDescripcion()+"; "+producto.getTipoProducto()+"; "+producto.getPrecio()+"; "
                        +producto.getFechaC());
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Error leyendo el catálogo de productos");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarProducto(String nombreCatalogoP, String buscar) {
        try {
            System.out.println(this.datos.buscarNombreP(nombreCatalogoP, buscar));
        } catch (LecturaDatosEx ex) {
           ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void buscarProductoId(String nombreCatalogoP, int buscar) {
        try {
            System.out.println(this.datos.buscarProductoPorId(nombreCatalogoP, buscar));
        } catch (LecturaDatosEx ex) {
           ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogoP(String nombreCatalogoP) {
        try {
        if (this.datos.existeP(nombreCatalogoP)){
            this.datos.borrarArchivoP(nombreCatalogoP);
            this.datos.crearArchivoP(nombreCatalogoP);
        } else{
            this.datos.crearArchivoP(nombreCatalogoP);
        }
        } catch (AccesoDatosEx ex){
            ex.printStackTrace(System.out);
            System.out.println("Error al inicializar el catálogo de productos");
        }
    }

    @Override
    public void borrarP(String nombreCatalogoP, String nombreProducto) {
        try {
            this.datos.borrarProducto(nombreCatalogoP, nombreProducto);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Excepción a la hora de borrar un producto");
        }
        System.out.println("Producto borrado con éxito");
    }

    @Override
    public String borrarCatalogoP(String nombreCatalogoP) {
        this.datos.borrarArchivoP(nombreCatalogoP);
        return "Catalogo de productos borrado.";
    }
    
}
