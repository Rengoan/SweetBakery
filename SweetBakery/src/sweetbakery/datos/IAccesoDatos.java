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
    
    
    void agregarP(Productos producto, String nombreArchivoP) throws EscrituraDatosEx;
    void agregarC(Cliente cliente, String nombreArchivoC) throws EscrituraDatosEx;
    void agregarEmp(Empleado empleado, String nombreArchivoEmp) throws EscrituraDatosEx;
    
    String buscarNombreP(String nombreArchivoP, String buscar) throws LecturaDatosEx;
    String buscarNombreC(String nombreArchivoC, String buscar) throws LecturaDatosEx;
    String buscarNombreEmp(String nombreArchivoEmp, String buscar) throws LecturaDatosEx;
    
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
