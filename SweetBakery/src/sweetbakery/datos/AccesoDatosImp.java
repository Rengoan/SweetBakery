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
        String[] producto = new String[6];
        List<Productos> productos = new ArrayList<>();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            while ((lectura = entrada.readLine()) != null) {

                producto = lectura.split(";"); // {idPruducto, nombreProducto,descripcion, precio,fecha}
                productoN = new Productos(Integer.parseInt(producto[0]),
                        producto[1], producto[2], TipoProducto.valueOf(producto[3]),
                        Double.parseDouble(producto[4]),
                        formatoFecha.parse(producto[5]));
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

//    @Override
//    public void escribirP(Productos producto, String nombreArchivoP, boolean anexar) throws EscrituraDatosEx {
//            File archivo = new File(nombreArchivoP);
//        
//        try {
//            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
//            salida.println(producto.getTipoProducto(),producto.getPrecio(),producto.getFechaC());
//            salida.close();
//        } catch (IOException ex) {
//            ex.printStackTrace(System.out);
//            throw new EscrituraDatosEx("Excepción al escribir en el archivo");
//        }
//    }
//
//    @Override
//    public void escribirC(Cliente cliente, String nombreArchivoC, boolean anexar) throws EscrituraDatosEx {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void escribirEmp(Empleado empleado, String nombreArchivoEmp, boolean anexar) throws EscrituraDatosEx {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public void agregarP(Productos producto, String nombreArchivoP) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivoP);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String productoTxt = producto.getIdProducto() + ";"
                    + producto.getNombreProducto() + ";" + producto.getDescripcion() + ";"
                    + producto.getTipoProducto() + ";" + producto.getPrecio() + ";"
                    + producto.getFechaC();
            salida.println(productoTxt);
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepción escribiendo un nuevo "
                    + "producto en el archivo");
        }
    }

    @Override
    public void agregarC(Cliente cliente, String nombreArchivoC) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivoC);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String productoTxt = cliente.getIdCliente() + ";"
                    + cliente.getNombre() + ";" + cliente.getApellido() + ";"
                    + cliente.getCorreo() + ";" + cliente.getTlf();
            salida.println(productoTxt);
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepción escribiendo un nuevo "
                    + "cliente en el archivo");
        }
    }

    @Override
    public void agregarEmp(Empleado empleado, String nombreArchivoEmp) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivoEmp);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String productoTxt = empleado.getIdEmp() + ";"
                    + empleado.getNombre() + ";" + empleado.getApellidos() + ";"
                    + empleado.getCorreo() + ";" + empleado.getTlfEmp() + ";" + empleado.getSsocial() + ";"
                    + empleado.getCbancaria();
            salida.println(productoTxt);
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepción escribiendo un nuevo "
                    + "empleado en el archivo");
        }
    }

    @Override
    public String buscarNombreP(String nombreArchivoP, String buscar) throws LecturaDatosEx {
         File archivo = new File(nombreArchivoP);
        String mensaje = "";
        int cont = 1;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            while (lectura != null) {
                String[] producto = lectura.split(";"); 
                if(producto[1].equalsIgnoreCase(buscar)){
                    mensaje = "El producto " + buscar + " se encuentra en la "
                            + "línea " + cont + " del catálogo de productos";
                    break;
                }
                
                lectura = entrada.readLine();
                cont++;
            }
            
            if(lectura == null) {
                 mensaje = "El producto " + buscar + " no está "
                    + "en el catálogo de productos.";
            }
            
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los productos");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Error de lectura listando los productos");
        }
        
        return mensaje;
    }

    @Override
    public String buscarNombreC(String nombreArchivoC, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivoC);
        String mensaje = "";
        int cont = 1;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            while (lectura != null) {
                String[] cliente = lectura.split(";"); 
                if(cliente[1].equalsIgnoreCase(buscar)){
                    mensaje = "El cliente " + buscar + " se encuentra en la "
                            + "línea " + cont + " del catálogo de clientes";
                    break;
                }
                
                lectura = entrada.readLine();
                cont++;
            }
            
            if(lectura == null) {
                 mensaje = "El cliente " + buscar + " no está "
                    + "en el catálogo de clientes.";
            }
            
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los clientes");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Error de lectura listando los clientes");
        }
        
        return mensaje;
    
    
    }

    @Override
    public String buscarNombreEmp(String nombreArchivoEmp, String buscar) throws LecturaDatosEx {
       File archivo = new File(nombreArchivoEmp);
        String mensaje = "";
        int cont = 1;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            while (lectura != null) {
                String[] empleado = lectura.split(";"); 
                if(empleado[1].equalsIgnoreCase(buscar)){
                    mensaje = "El empleado " + buscar + " se encuentra en la "
                            + "línea " + cont + " del catálogo de empleados";
                    break;
                }
                
                lectura = entrada.readLine();
                cont++;
            }
            
            if(lectura == null) {
                 mensaje = "El empleado " + buscar + " no está "
                    + "en el catálogo de empleados.";
            }
            
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los empleados");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Error de lectura listando los empleados");
        }
        
        return mensaje;

    }

    @Override
    public Productos buscarProductoPorId(String nombreArchivoP, int id) throws LecturaDatosEx {
        File archivo = new File(nombreArchivoP);
        String[] productoTxt = new String[6];
        Productos producto = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;

            while ((lectura = entrada.readLine()) != null) {
                productoTxt = lectura.split(";"); // {idArticulo(0), nombre(1), descripcion(2), precio(3), fecha(4)}
                if (id == Integer.parseInt(productoTxt[0])) {
                    producto = new Productos(Integer.parseInt(productoTxt[0]),
                            productoTxt[1], productoTxt[2], TipoProducto.valueOf(productoTxt[3]), Double.parseDouble(productoTxt[4]),
                            formatoFecha.parse(productoTxt[5]));
                    break;
                }
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion leyendo el recurso al "
                    + "buscar el producto con id " + id);
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
        }
        return producto;
    }

    @Override
    public Cliente buscarClientePorId(String nombreArchivoC, int id) throws LecturaDatosEx {
        File archivo = new File(nombreArchivoC);
        String[] clienteTxt = new String[5];
        Cliente cliente = null;

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;

            while ((lectura = entrada.readLine()) != null) {
                clienteTxt = lectura.split(";"); // {idArticulo(0), nombre(1), descripcion(2), precio(3), fecha(4)}
                if (id == Integer.parseInt(clienteTxt[0])) {
                    cliente = new Cliente(Integer.parseInt(clienteTxt[0]),
                            clienteTxt[1], clienteTxt[2],
                            clienteTxt[3], clienteTxt[4]);
                    break;
                }
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion leyendo el recurso al "
                    + "buscar el Cliente con id " + id);
        }
        return cliente;
    }

    @Override
    public Empleado buscarEmpleadoPorId(String nombreArchivoEmp, int id) throws LecturaDatosEx {
        File archivo = new File(nombreArchivoEmp);
        String[] empleadoTxt = new String[7];
        Empleado empleado = null;

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;

            while ((lectura = entrada.readLine()) != null) {
                empleadoTxt = lectura.split(";"); // {idArticulo(0), nombre(1), descripcion(2), precio(3), fecha(4)}
                if (id == Integer.parseInt(empleadoTxt[0])) {
                    empleado = new Empleado(Integer.parseInt(empleadoTxt[0]),
                            empleadoTxt[1], empleadoTxt[2],
                            empleadoTxt[3], empleadoTxt[4], empleadoTxt[5], empleadoTxt[6]);
                    break;
                }
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion leyendo el recurso al "
                    + "buscar el empleado con id " + id);
        }
        return empleado;
    }

    @Override
    public void borrarProducto(String nombreArchivoP, String nombreProducto) throws AccesoDatosEx {
        File archivoOri = new File(nombreArchivoP);
        File archivoBackup = new File("temp.txt");

        String[] producto = new String[6];

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivoOri));
            PrintWriter salida = new PrintWriter(new FileWriter(archivoBackup));
            String lectura = null;

            while ((lectura = entrada.readLine()) != null) {

                producto = lectura.split(";");
                if (producto[1] != nombreProducto) {
                    salida.println(producto);
                }

            }
            entrada.close();
            salida.close();

            if (existeP(nombreArchivoP)) {
                borrarArchivoP(nombreArchivoP);
            }

            archivoBackup.renameTo(archivoOri);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrarCliente(String nombreArchivoC, String nombreCliente) throws AccesoDatosEx {
        File archivoOri = new File(nombreArchivoC);
        File archivoBackup = new File("temp.txt");

        String[] cliente = new String[5];

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivoOri));
            PrintWriter salida = new PrintWriter(new FileWriter(archivoBackup));
            String lectura = null;

            while ((lectura = entrada.readLine()) != null) {

                cliente = lectura.split(";");
                if (cliente[1] != nombreCliente) {
                    salida.println(cliente);
                }

            }
            entrada.close();
            salida.close();

            if (existeC(nombreArchivoC)) {
                borrarArchivoC(nombreArchivoC);
            }

            archivoBackup.renameTo(archivoOri);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrarEmpleado(String nombreArchivoEmp, String nombreEmpleado) throws AccesoDatosEx {
        File archivoOri = new File(nombreArchivoEmp);
        File archivoBackup = new File("temp.txt");

        String[] empleado = new String[7];

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivoOri));
            PrintWriter salida = new PrintWriter(new FileWriter(archivoBackup));
            String lectura = null;

            while ((lectura = entrada.readLine()) != null) {

                empleado = lectura.split(";");
                if (empleado[1] != nombreEmpleado) {
                    salida.println(empleado);
                }

            }
            entrada.close();
            salida.close();

            if (existeEmp(nombreArchivoEmp)) {
                borrarArchivoEmp(nombreArchivoEmp);
            }

            archivoBackup.renameTo(archivoOri);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public String borrarArchivoP(String nombreArchivoP) {
        File archivo = new File(nombreArchivoP);
        String msg = "";
        if (existeP(nombreArchivoP)) {
            archivo.delete();
            msg = "Recurso borrado con éxito";
        } else {
            msg = "No se ha podido borrar el archivo ya que no existe";
        }
        return msg;
    }

    @Override
    public String borrarArchivoC(String nombreArchivoC) {
        File archivo = new File(nombreArchivoC);
        String msg = "";
        if (existeP(nombreArchivoC)) {
            archivo.delete();
            msg = "Recurso borrado con éxito";
        } else {
            msg = "No se ha podido borrar el archivo ya que no existe";
        }
        return msg;
    }

    @Override
    public String borrarArchivoEmp(String nombreArchivoEmp) {
        File archivo = new File(nombreArchivoEmp);
        String msg = "";
        if (existeP(nombreArchivoEmp)) {
            archivo.delete();
            msg = "Recurso borrado con éxito";
        } else {
            msg = "No se ha podido borrar el archivo ya que no existe";
        }
        return msg;
    }

}
