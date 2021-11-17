package sweetbakery.datos;

import java.util.*;
import sweetbakery.dominio.*;
import sweetbakery.excepciones.*;

public interface IAccesoDatos {
    
    
    boolean existe(String nombreArchivo);
    
    List<Productos> ListarP(String nombreArchivoP) throws LecturaDatosEx;
    List<Cliente> ListarC(String nombreArchivoC) throws LecturaDatosEx;
    List<Empleado> ListarEmp(String nombreArchivoEmp) throws LecturaDatosEx;
    
    void escribirP (Productos productos,String nombreArchivoP, boolean anexar) throws EscrituraDatosEx;
    void escribirC (Cliente clientes,String nombreArchivoC, boolean anexar) throws EscrituraDatosEx;
    void escribirEmp (Empleado empleados,String nombreArchivoEmp, boolean anexar) throws EscrituraDatosEx;
}
