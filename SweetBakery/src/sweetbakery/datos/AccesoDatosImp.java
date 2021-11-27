package sweetbakery.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import sweetbakery.dominio.Cliente;
import sweetbakery.dominio.Empleado;
import sweetbakery.dominio.Productos;
import sweetbakery.dominio.TipoProducto;
import sweetbakery.excepciones.AccesoDatosEx;
import sweetbakery.excepciones.EscrituraDatosEx;
import sweetbakery.excepciones.LecturaDatosEx;

public class AccesoDatosImp implements IAccesoDatos {

    @Override
    public boolean existeP(String nombreArchivoP) {
        File archivo = new File(nombreArchivoP);

        return archivo.exists();
    }

    @Override
    public boolean existeC(String nombreArchivoC) {
        File archivo = new File(nombreArchivoC);

        return archivo.exists();
    }

    @Override
    public boolean existeEmp(String nombreArchivoEmp) {
        File archivo = new File(nombreArchivoEmp);

        return archivo.exists();
    }

    @Override
    public void crearArchivoP(String nombreArchivoP) throws AccesoDatosEx {
        File archivo = new File(nombreArchivoP);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepción intentando crear el archivo de productos");
        }
    }

    @Override
    public void crearArchivoC(String nombreArchivoC) throws AccesoDatosEx {
        File archivo = new File(nombreArchivoC);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepción intentando crear el archivo de clientes");
        }
    }

    @Override
    public void crearArchivoEmp(String nombreArchivoEmp) throws AccesoDatosEx {
        File archivo = new File(nombreArchivoEmp);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepción intentando crear el archivo de empleados");
        }
    }

    @Override
    public List<Productos> ListarP(String nombreArchivoP) throws LecturaDatosEx {
        File archivo = new File(nombreArchivoP);

        Productos productoN = null;
        String[] producto = new String[4];
        List<Productos> productos = new ArrayList<>();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            while ((lectura = entrada.readLine()) != null) {

                producto = lectura.split(";"); // {idPruducto, TipoProducto(enum), precio,fecha}
                productoN = new Productos(Integer.parseInt(producto[0]),
                        producto[1], Double.parseDouble(producto[2]),
                        formatoFecha.parse(producto[3]));
                productos.add(productoN);
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepción leyendo el fichero productos...");
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
        }
        return productos;
    }

    @Override
    public List<Cliente> ListarC(String nombreArchivoC) throws LecturaDatosEx {
        File archivo = new File(nombreArchivoC);

        Cliente clienteN = null;
        String[] cliente = new String[5];
        List<Cliente> clientes = new ArrayList<>();

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            while ((lectura = entrada.readLine()) != null) {

                cliente = lectura.split(";"); // {idCliente, nombre, apellido, correo, tlf}
                clienteN = new Cliente(Integer.parseInt(cliente[0]),
                        cliente[1], cliente[2],
                        cliente[3], cliente[4]);
                clientes.add(clienteN);
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepción leyendo el fichero cliente...");
        }
        return clientes;

    }

    @Override
    public List<Empleado> ListarEmp(String nombreArchivoEmp) throws LecturaDatosEx {

        File archivo = new File(nombreArchivoEmp);
        Empleado empleadoN = null;
        String[] empleado = new String[7];
        List<Empleado> empleados = new ArrayList<>();

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            while ((lectura = entrada.readLine()) != null) {

                empleado = lectura.split(";"); // {idEmp, nombre, apellidos, correo, tlfEmp,Ssocial,Cbancaria}
                empleadoN = new Empleado(Integer.parseInt(empleado[0]),
                        empleado[1], empleado[2],
                        empleado[3], empleado[4], empleado[5], empleado[6]);
                empleados.add(empleadoN);
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepción leyendo el fichero empleados...");
        }
        return empleados;
    }

    @Override
    public void escribirP(Productos producto, String nombreArchivoP, boolean anexar) throws EscrituraDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void escribirC(Cliente cliente, String nombreArchivoC, boolean anexar) throws EscrituraDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void escribirEmp(Empleado empleado, String nombreArchivoEmp, boolean anexar) throws EscrituraDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarP(Productos producto, String nombreArchivoP) throws EscrituraDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarC(Cliente cliente, String nombreArchivoC) throws EscrituraDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarEmp(Empleado empleado, String nombreArchivoEmp) throws EscrituraDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int buscarNombreP(String nombreArchivoP, String termino) throws LecturaDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int buscarNombreC(String nombreArchivoC, String termino) throws LecturaDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int buscarNombreEmp(String nombreArchivoEmp, String termino) throws LecturaDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Productos buscarProductoPorId(String nombreArchivoP, int id) throws LecturaDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscarClientePorId(String nombreArchivoC, int id) throws LecturaDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado buscarEmpleadoPorId(String nombreArchivoEmp, int id) throws LecturaDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarProducto(String nombreArchivoP, String nombreProducto) throws AccesoDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarCliente(String nombreArchivoC, String nombreCliente) throws AccesoDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarEmpleado(String nombreArchivoEmp, String nombreEmpleado) throws AccesoDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String borrarArchivoP(String nombreArchivoP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String borrarArchivoC(String nombreArchivoC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String borrarArchivoEmp(String nombreArchivoEmp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
