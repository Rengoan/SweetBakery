package sweetbakery.principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import sweetbakery.dominio.TipoProducto;
import sweetbakery.negocio.ClientesImp;
import sweetbakery.negocio.EmpleadoImp;
import sweetbakery.negocio.IClientes;
import sweetbakery.negocio.IEmpleado;
import sweetbakery.negocio.IProductos;
import sweetbakery.negocio.ProductosImp;

public class Pantalla {

    public static void main(String[] args) {

        var opcion = -1;
        var opcionP = -1;
        var opcionC = -1;
        var opcionEmp = -1;
        var opcionEnum = -1;

//        var Producto = "";
//        var Cliente = "";
//        var Empleado = "";

        var lectura = new Scanner(System.in);
        
        int idProductoBusq;
        String nombreProductoB = "";
        int idProducto = 0;
        String nombreProducto = "";
        String descripcion = "";
        TipoProducto tipoProducto = null;
        double precio = 0.0;
        Date fechaC;

        int idClienteBusq;
        String nombreClienteB = "";
        int idCliente = 0;
        String nombreC = "";
        String apellido = "";
        String correo = "";
        String tlf = "";
        

        int BusquedaIdEmp;
        String nombreEmpB = "";
        int idEmp = 0;
        String nombreEmp = "";
        String apellidosEmp = "";
        String correoEmp = "";
        String tlfEmp = "";
        String Ssocial = "";
        String Cbancaria = "";

        var nombreCatalogoP = "Productos.txt";
        var nombreCatalogoC = "Clientes.txt";
        var nombreCatalogoEmp = "Empleados.txt";

        IProductos catalogoP = new ProductosImp();
        IClientes catalogoC = new ClientesImp();
        IEmpleado catalogoEmp = new EmpleadoImp();

        while (opcion != 0) {
            System.out.println("Elige una de las opciones: \n"
                    + "1.- Catalogo productos \n"
                    + "2.- Catalogo Clientes. \n"
                    + "3.- Catalogo Empleados. \n"
                    + "0.- Salir \n");
            // Leemos la opción del la consola
            opcion = Integer.parseInt(lectura.nextLine());

            switch (opcion) {
                case 1:

                    while (opcionP != 0) {
                        System.out.println("Elige una de las opciones: \n"
                                + "1.- Iniciar catálogo de Productos. \n"
                                + "2.- Agregar Producto. \n"
                                + "3.- Listar Productos. \n"
                                + "4.- Buscar Productos. \n"
                                + "5.- Buscar Producto por codigo. \n"
                                + "6.- Borrar producto por nombre. \n"
                                + "7.- Borrar Producto de Clientes. \n"
                                + "0.- Salir \n");

                        opcionP = Integer.parseInt(lectura.nextLine());
                        switch (opcionP) {
                            case 1:
                                catalogoP.iniciarCatalogoP(nombreCatalogoP);
                                System.out.println("Catálogo de productos iniciado.");
                                break;
                            case 2:
                                idProducto++;
                                System.out.println("Introduce el nombre del producto a agregar: ");
                                nombreProducto = lectura.nextLine();
                                System.out.println("Introduce la descripcion del producto a agregar: ");
                                descripcion = lectura.nextLine();
                                while (opcionEnum != 0) {
                                    System.out.println("Elige el tamaño del producto: \n"
                                            + "1.- Para 2 personas. \n"
                                            + "2.- Para 5 personas. \n"
                                            + "3.- Para 8 personas. \n"
                                            + "4.- Para eventos. \n"
                                            + "0.- Salir \n");

                                    opcionEnum = Integer.parseInt(lectura.nextLine());
                                    switch (opcionEnum) {
                                        case 1:
                                            tipoProducto.TARTAPEQUENIA.toString();
                                            break;
                                        case 2:
                                            tipoProducto.TARTAMEDIANA.toString();
                                            break;
                                        case 3:
                                            tipoProducto.TARTAGRANDE.toString();
                                            break;
                                        case 4:
                                            tipoProducto.TARTAEVENTO.toString();
                                            break;
                                    }
                                }

                                System.out.println("Introduce el precio del producto a agregar: ");
                                precio = lectura.nextDouble();
                                System.out.println("Introduzca la fecha de caducidad del producto con formato dd/mm/yyyy");
                                String fecha = lectura.next();
                                fechaC = convertirFecha(fecha);
                                catalogoP.agregarProducto(idProducto, nombreProducto, descripcion, 
                                        tipoProducto, precio, fechaC, nombreCatalogoP);
                                System.out.println("Se ha agregado el nombre " + nombreProducto 
                                        + " ,de que es el producto " + descripcion
                                        + " ,el tipo de producto " + tipoProducto + " ,el precio " 
                                        + precio + " ,y la fecha de caducidad del producto " 
                                        + fechaC + " al catalogo de productos "
                                        + nombreCatalogoP);
                                break;
                            case 3:
                                catalogoP.listarProductos(nombreCatalogoP);
                                break;
                             case 4:

                                System.out.println("Introduce el nombre del producto que quieres buscar: ");
                                nombreProducto = lectura.nextLine();
                                catalogoC.buscarCliente(nombreCatalogoP, nombreProducto);

                                break;
                            case 5:

                                System.out.println("Introduce el codigo del producto que quieres buscar: ");
                                idProductoBusq = Integer.parseInt(lectura.nextLine());
                                catalogoC.buscarClienteId(nombreCatalogoP, idProductoBusq);

                                break;
                            case 6:

                                System.out.println("Introduce el nombre del Producto que quieres borrar: ");
                                nombreProductoB = lectura.nextLine();
                                catalogoC.borrarC(nombreCatalogoP, nombreProductoB);

                                break;
                            case 7:

                                catalogoP.borrarCatalogoP(nombreCatalogoP);
                                System.out.println("Catalogo de productos borrado");

                                break;
                            case 0:
                                System.out.println("Adios y hasta pronto!!! :(");
                                break;
                            default:
                                System.out.println("Opción desconocida.");

                        }
                    }

                    break;
                case 2:
                    while (opcionC != 0) {
                        System.out.println("Elige una de las opciones: \n"
                                + "1.- Iniciar catálogo de Clientes. \n"
                                + "2.- Agregar Cliente. \n"
                                + "3.- Listar Clientes. \n"
                                + "4.- Buscar Clientes. \n"
                                + "5.- Buscar Clientes por codigo. \n"
                                + "6.- Borrar Clientes por nombre. \n"
                                + "7.- Borrar Catalogo de Clientes. \n"
                                + "0.- Salir \n");
                        opcionC = Integer.parseInt(lectura.nextLine());
                        switch (opcionC) {
                            case 1:
                                catalogoC.iniciarCatalogoC(nombreCatalogoC);
                                System.out.println("Catálogo de Clientes iniciado.");
                                break;

                            case 2:

                                
                                idCliente++;
                                System.out.println("Introduce el nombre del cliente a agregar: ");
                                nombreC = lectura.nextLine();
                                System.out.println("Introduce el apellido del cliente a agregar: ");
                                apellido = lectura.nextLine();
                                System.out.println("Introduce el correo del cliente a agregar: ");
                                correo = lectura.nextLine();
                                System.out.println("Introduce el telefono del cliente a agregar: ");
                                tlf = lectura.nextLine();
                                catalogoC.agregarCliente(idCliente, nombreC, apellido, correo, tlf, nombreCatalogoC);
                                System.out.println("Se ha agregado el nombre " + nombreC + " ,el apellido " + apellido
                                        + " ,el correo " + correo + " ,y el telefono " + tlf + " al catalogo de "
                                        + nombreCatalogoC);
                                break;
                            case 3:
                                catalogoC.listarCliente(nombreCatalogoC);
                                break;
                            case 4:

                                System.out.println("Introduce el nombre del cliente que quieres buscar: ");
                                nombreC = lectura.nextLine();
                                catalogoC.buscarCliente(nombreCatalogoC, nombreC);

                                break;
                            case 5:

                                System.out.println("Introduce el codigo del cliente que quieres buscar: ");
                                idClienteBusq = Integer.parseInt(lectura.nextLine());
                                catalogoC.buscarClienteId(nombreCatalogoC, idClienteBusq);

                                break;
                            case 6:

                                System.out.println("Introduce el nombre del cliente que quieres borrar: ");
                                nombreClienteB = lectura.nextLine();
                                catalogoC.borrarC(nombreCatalogoC, nombreClienteB);

                                break;
                            case 7:

                                catalogoC.borrarCatalogoC(nombreCatalogoC);
                                System.out.println("Catalogo de clientes borrado");

                                break;
                            case 0:
                                System.out.println("Has vuelto al menu principal!!! ");
                                break;
                            default:
                                System.out.println("Opción desconocida.");

                        }
                    }
                    break;
                case 3:

                    while (opcionEmp != 0) {
                        System.out.println("Elige una de las opciones: \n"
                                + "1.- Iniciar catálogo de Empleados. \n"
                                + "2.- Agregar Empleado. \n"
                                + "3.- Listar Empleado. \n"
                                + "4.- Buscar Empleados. \n"
                                + "5.- Buscar Empleados por codigo. \n"
                                + "6.- Borrar Empleado por nombre. \n"
                                + "7.- Borrar Catalogo de empleados. \n"
                                + "0.- Salir \n");
                        opcionEmp = Integer.parseInt(lectura.nextLine());
                        switch (opcionEmp) {
                            case 1:
                                catalogoEmp.iniciarCatalogoEmp(nombreCatalogoEmp);
                                System.out.println("Catálogo de Clientes iniciado.");
                                break;

                            case 2:

                                idEmp++;
                                System.out.println("Introduce el nombre del empleado a agregar: ");
                                nombreEmp = lectura.nextLine();
                                System.out.println("Introduce el apellido del empleado a agregar: ");
                                apellidosEmp = lectura.nextLine();
                                System.out.println("Introduce el correo del empleado a agregar: ");
                                correoEmp = lectura.nextLine();
                                System.out.println("Introduce el telefono de empresa del empleado a agregar: ");
                                tlfEmp = lectura.nextLine();
                                System.out.println("Introduce el numero de la Seguridad social del empleado a agregar: ");
                                Ssocial = lectura.nextLine();
                                System.out.println("Introduce el numero de cuenta bancaria del empleado a agregar: ");
                                Cbancaria = lectura.nextLine();
                                catalogoEmp.agregarEmpleado(idEmp, nombreEmp, apellidosEmp, correoEmp, tlfEmp, Ssocial, Cbancaria, nombreCatalogoEmp);
                                System.out.println("Se ha agregado el nombre " + nombreEmp + " ,el apellido " + apellidosEmp
                                        + " ,el correo " + correoEmp + " ,y el telefono " + tlfEmp + " al catalogo de "
                                        + nombreCatalogoEmp);
                                break;
                            case 3:
                                catalogoEmp.listarEmpleado(nombreCatalogoEmp);
                                break;
                            case 4:

                                System.out.println("Introduce el nombre del empleado que quieres buscar: ");
                                nombreEmp = lectura.nextLine();
                                catalogoEmp.buscarEmpleado(nombreCatalogoEmp, nombreEmp);

                                break;
                            case 5:

                                System.out.println("Introduce el codigo del empleado que quieres buscar: ");
                                BusquedaIdEmp = Integer.parseInt(lectura.nextLine());
                                catalogoEmp.buscarEmpleadoId(nombreCatalogoEmp, BusquedaIdEmp);

                                break;
                            case 6:

                                System.out.println("Introduce el nombre del empleado que quieres borrar: ");
                                nombreEmpB = lectura.nextLine();
                                catalogoEmp.borrarEmp(nombreCatalogoEmp, nombreEmpB);

                                break;
                            case 7:

                                catalogoEmp.borrarCatalogoEmp(nombreCatalogoEmp);
                                System.out.println("Catalogo de empleados borrado");

                                break;
                            case 0:
                                System.out.println("Has vuelto al menu principal!!!");
                                break;
                            default:
                                System.out.println("Opción desconocida.");

                        }
                    }
                    break;

                case 0:
                    System.out.println("Adios y hasta pronto!!! :(");
                    break;
                default:
                    System.out.println("Opción desconocida.");

            }
        }

    }

    private static Date convertirFecha(String fecha) {
        //Formato de la fecha a convertir
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaC = null;
        try {
            fechaC = df.parse(fecha);
        } catch (ParseException ex) {

        }
        return fechaC;
    }
}
