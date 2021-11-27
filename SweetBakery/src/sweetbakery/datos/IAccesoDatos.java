package sweetbakery.datos;

import java.util.*;
import sweetbakery.dominio.*;
import sweetbakery.excepciones.*;

public interface IAccesoDatos {
    
    
    boolean existeP(String nombreArchivoP);
    boolean existeC(String nombreArchivoC);
    boolean existeEmp(String nombreArchivoEmp);
    
    void crearArchivoP(String nombreArchivoP) throws AccesoDatosEx;
    void crearArchivoC(String nombreArchivoC) throws AccesoDatosEx;
    void crearArchivoEmp(String nombreArchivoEmp) throws AccesoDatosEx;
    
    List<Productos> ListarP(String nombreArchivoP) throws LecturaDatosEx;
    List<Cliente> ListarC(String nombreArchivoC) throws LecturaDatosEx;
    List<Empleado> ListarEmp(String nombreArchivoEmp) throws LecturaDatosEx;
    
//    void escribirP (Productos producto,String nombreArchivoP, boolean anexar) throws EscrituraDatosEx;
//    void escribirC (Cliente cliente,String nombreArchivoC, boolean anexar) throws EscrituraDatosEx;
//    void escribirEmp (Empleado empleado,String nombreArchivoEmp, boolean anexar) throws EscrituraDatosEx;
    
    void agregarP(Productos producto, String nombreArchivoP) throws EscrituraDatosEx;
    void agregarC(Cliente cliente, String nombreArchivoC) throws EscrituraDatosEx;
    void agregarEmp(Empleado empleado, String nombreArchivoEmp) throws EscrituraDatosEx;
    
    int buscarNombreP(String nombreArchivoP, String termino) throws LecturaDatosEx;
    int buscarNombreC(String nombreArchivoC, String termino) throws LecturaDatosEx;
    int buscarNombreEmp(String nombreArchivoEmp, String termino) throws LecturaDatosEx;
    
    Productos buscarProductoPorId(String nombreArchivoP, int id) throws LecturaDatosEx;
    Cliente buscarClientePorId(String nombreArchivoC, int id) throws LecturaDatosEx;
    Empleado buscarEmpleadoPorId(String nombreArchivoEmp, int id) throws LecturaDatosEx;
    
    void borrarProducto(String nombreArchivoP, String nombreProducto) throws AccesoDatosEx;
    void borrarCliente(String nombreArchivoC, String nombreCliente) throws AccesoDatosEx;
    void borrarEmpleado(String nombreArchivoEmp, String nombreEmpleado) throws AccesoDatosEx;
    
    String borrarArchivoP(String nombreArchivoP);
    String borrarArchivoC(String nombreArchivoC);
    String borrarArchivoEmp(String nombreArchivoEmp);
    
    
}
