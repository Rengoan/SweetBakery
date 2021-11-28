package sweetbakery.principal;

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

        var Producto = "";
        var Cliente = "";
        var Empleado = "";

        var lectura = new Scanner(System.in);

        int idCliente = 0;
        String nombreC = "";
        String apellido = "";
        String correo = "";
        String tlf = "";

        int BusquedaIdEmp = 0;
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

        IProductos catalagoP = new ProductosImp();
        IClientes catalogoC = new ClientesImp();
        IEmpleado catalagoEmp = new EmpleadoImp();

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
                                + "0.- Salir \n");

                        opcionP = Integer.parseInt(lectura.nextLine());
                        switch (opcionP) {
                            case 1:
                                catalagoP.iniciarCatalogoP(nombreCatalogoP);
                                System.out.println("Catálogo de productos iniciado.");

                                //                            case 2:
                                //                                String nombre = "";
                                //                                String apellido = "";
                                //                                String correo = "";
                                //                                String tlf = "";
                                //                                System.out.println("Introduce el nombre del cliente a agregar: ");
                                //                                nombre = lectura.nextLine();
                                //                                System.out.println("Introduce el apellido del cliente a agregar: ");
                                //                                apellido = lectura.nextLine();
                                //                                System.out.println("Introduce el correo del cliente a agregar: ");
                                //                                correo = lectura.nextLine();
                                //                                System.out.println("Introduce el telefono del cliente a agregar: ");
                                //                                tlf = lectura.nextLine();
                                //                                catalagoC.agregarCliente(nombre, apellido, correo, tlf, nombreCatalogoC);
                                //                                System.out.println("Se ha agregado el nombre " + nombre + " ,el apellido " + apellido
                                //                                        + " ,el correo " + correo + " ,y el telefono " + tlf + " al catalogo de clientes "
                                //                                        + nombreCatalogoC);
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
                                idCliente = lectura.nextInt();
                                catalogoC.buscarClienteId(nombreCatalogoC, idEmp);

                                break;
                            case 6:

                                System.out.println("Introduce el nombre del cliente que quieres borrar: ");
                                nombreC = lectura.nextLine();
                                catalogoC.borrarC(nombreCatalogoC, nombreC);

                                break;
                            case 7:

                                catalogoC.borrarCatalogoC(nombreCatalogoC);
                                System.out.println("Catalogo de empleados borrado");

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
                                catalagoEmp.iniciarCatalogoEmp(nombreCatalogoEmp);
                                System.out.println("Catálogo de Clientes iniciado.");
                                break;

                            case 2:
                                
                                idEmp ++;
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
                                catalagoEmp.agregarEmpleado(idEmp, nombreEmp, apellidosEmp, correoEmp, tlfEmp, Ssocial, Cbancaria, nombreCatalogoEmp);
                                System.out.println("Se ha agregado el nombre " + nombreEmp + " ,el apellido " + apellidosEmp
                                        + " ,el correo " + correoEmp + " ,y el telefono " + tlfEmp + " al catalogo de "
                                        + nombreCatalogoEmp);
                                break;
                            case 3:
                                catalagoEmp.listarEmpleado(nombreCatalogoEmp);
                                break;
                            case 4:

                                System.out.println("Introduce el nombre del empleado que quieres buscar: ");
                                nombreEmp = lectura.nextLine();
                                catalagoEmp.buscarEmpleado(nombreCatalogoEmp, nombreEmp);

                                break;
                            case 5:

                                System.out.println("Introduce el codigo del empleado que quieres buscar: ");
                                BusquedaIdEmp = lectura.nextInt();
                                catalagoEmp.buscarEmpleadoId(nombreCatalogoEmp, idEmp);

                                break;
                            case 6:

                                System.out.println("Introduce el nombre del empleado que quieres borrar: ");
                                nombreEmp = lectura.nextLine();
                                catalagoEmp.borrarEmp(nombreCatalogoEmp, nombreEmp);

                                break;
                            case 7:

                                catalagoEmp.borrarCatalogoEmp(nombreCatalogoEmp);
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
}
