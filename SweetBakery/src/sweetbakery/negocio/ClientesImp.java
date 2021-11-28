package sweetbakery.negocio;

import java.util.ArrayList;
import java.util.List;
import sweetbakery.datos.AccesoDatosImp;
import sweetbakery.datos.IAccesoDatos;
import sweetbakery.dominio.Cliente;
import sweetbakery.excepciones.AccesoDatosEx;
import sweetbakery.excepciones.EscrituraDatosEx;
import sweetbakery.excepciones.LecturaDatosEx;

public class ClientesImp implements IClientes {

    
    private final IAccesoDatos datos;

    public ClientesImp( ) {
        this.datos= new AccesoDatosImp();
    }
    
    
    
    @Override
    public void agregarCliente(int idCliente,String nombre, String apellido, String correo, String tlf, String nombreCatalogoC) {
        try {
            if (this.datos.existeC(nombreCatalogoC)) {
                this.datos.agregarC(new Cliente(idCliente, nombre, apellido, correo, tlf), nombreCatalogoC);
            } else {
                System.out.println("Catálogo de clientes no inicilizado");
            }
        } catch (EscrituraDatosEx ex) {
            System.out.println("Error al escribir en el catálogo de clientes");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarCliente(String nombreCatalogoC) {
         List<Cliente> clientes = new ArrayList<>();

        try {
            clientes = this.datos.ListarC(nombreCatalogoC);
            clientes.forEach(cliente -> {
                System.out.println(cliente.getIdCliente()+"; "+cliente.getNombre()+"; "+cliente.getApellido()+"; "+
                        cliente.getCorreo()+"; "+cliente.getTlf());
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Error leyendo el catálogo de clientes");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarCliente(String nombreCatalogoC, String buscar) {
        try {
            System.out.println(this.datos.buscarNombreC(nombreCatalogoC, buscar));
        } catch (LecturaDatosEx ex) {
           ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarClienteId(String nombreCatalogoC, int buscar) {
        try {
            System.out.println(this.datos.buscarClientePorId(nombreCatalogoC, buscar));
        } catch (LecturaDatosEx ex) {
           ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogoC(String nombreCatalogoC) {
        try {
        if (this.datos.existeC(nombreCatalogoC)){
            this.datos.borrarArchivoC(nombreCatalogoC);
            this.datos.crearArchivoC(nombreCatalogoC);
        } else{
            this.datos.crearArchivoC(nombreCatalogoC);
        }
        } catch (AccesoDatosEx ex){
            ex.printStackTrace(System.out);
            System.out.println("Error al inicializar el catálogo de Clientes");
        }
    }

    @Override
    public void borrarC(String nombreCatalogoC, String nombreCliente) {
         try {
            this.datos.borrarCliente(nombreCatalogoC, nombreCliente);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Excepción a la hora de borrar un cliente");
        }
        System.out.println("Cliente borrado con éxito");
    }

    @Override
    public String borrarCatalogoC(String nombreCatalogoC) {
        this.datos.borrarArchivoC(nombreCatalogoC);
        return "Catalogo de clientes borrado.";
    }
    
}
