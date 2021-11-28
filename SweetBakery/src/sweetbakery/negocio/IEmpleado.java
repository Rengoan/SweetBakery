package sweetbakery.negocio;

public interface IEmpleado {
    
     // Agrega un empleado al archivo
    void agregarEmpleado(int idEmp, String nombre, String apellidos, String correo, String tlfEmp, String Ssocial, String Cbancaria, String nombreCatalogoEmp);
    
    // Mostrar todos los empleados del catálogo
    void listarEmpleado(String nombreCatalogoEmp);
    
    // Busca el empleado "Buscar" en nuestro catálogo
    void buscarEmpleado(String nombreCatalogoEmp, String buscar);
    
    String buscarEmpleadoId(String nombreCatalogoEmp, int id);
    
    // Nos inicia nuestro catálogo
    void iniciarCatalogoEmp(String nombreCatalogoEmp);
    
    void borrarEmp(String nombreCatalogoEmp, String nombreEmpleado);
    
    String borrarCatalogoEmp(String nombreCatalogoEmp);
}
