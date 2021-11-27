package sweetbakery.negocio;

import java.util.ArrayList;
import java.util.List;
import sweetbakery.datos.AccesoDatosImp;
import sweetbakery.datos.IAccesoDatos;
import sweetbakery.dominio.Cliente;
import sweetbakery.dominio.Empleado;
import sweetbakery.excepciones.AccesoDatosEx;
import sweetbakery.excepciones.EscrituraDatosEx;
import sweetbakery.excepciones.LecturaDatosEx;

public class EmpleadoImp implements IEmpleado {
    
    private final IAccesoDatos datos;

    public EmpleadoImp( ) {
        this.datos= new AccesoDatosImp();
    }

    @Override
    public void agregarEmpleado(int idEmp, String nombre, String apellidos, String correo, String tlfEmp, String Ssocial, String Cbancaria, String nombreCatalogoEmp) {
        try {
            if (this.datos.existeEmp(nombreCatalogoEmp)) {
                this.datos.agregarEmp(new Empleado(idEmp, nombre, apellidos, correo, tlfEmp, Ssocial, Cbancaria), nombreCatalogoEmp);
            } else {
                System.out.println("Catálogo de empleados no inicilizado");
            }
        } catch (EscrituraDatosEx ex) {
            System.out.println("Error al escribir en el catálogo de empleados");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarEmpleado(String nombreCatalogoEmp) {
         List<Empleado> empleados = new ArrayList<>();

        try {
            empleados = this.datos.ListarEmp(nombreCatalogoEmp);
            empleados.forEach(empleado -> {
                System.out.println(empleado.getIdEmp()+empleado.getNombre()+empleado.getApellidos()+
                        empleado.getCorreo()+empleado.getTlfEmp()+empleado.getSsocial()+empleado.getCbancaria());
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Error leyendo el catálogo de empleados");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarEmpleado(String nombreCatalogoEmp, String buscar) {
        try {
            System.out.println(this.datos.buscarNombreC(nombreCatalogoEmp, buscar));
        } catch (LecturaDatosEx ex) {
           ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarEmpleadoId(String nombreCatalogoEmp, int buscar) {
        try {
            System.out.println(this.datos.buscarEmpleadoPorId(nombreCatalogoEmp, buscar));
        } catch (LecturaDatosEx ex) {
           ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarEmpleadoC(String nombreCatalogoEmp) {
        try {
        if (this.datos.existeEmp(nombreCatalogoEmp)){
            this.datos.borrarArchivoEmp(nombreCatalogoEmp);
            this.datos.crearArchivoEmp(nombreCatalogoEmp);
        } else{
            this.datos.crearArchivoEmp(nombreCatalogoEmp);
        }
        } catch (AccesoDatosEx ex){
            ex.printStackTrace(System.out);
            System.out.println("Error al inicializar el catálogo de Empleados");
        }
    }
    
}
