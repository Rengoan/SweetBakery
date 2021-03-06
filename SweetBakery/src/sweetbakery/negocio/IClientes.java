package sweetbakery.negocio;

import sweetbakery.dominio.Cliente;

public interface IClientes {
    
     // Agrega un cliente al archivo
     void agregarCliente(int idCliente,String nombre, String apellido, String correo, String tlf, String nombreCatalogoC);
    
    // Mostrar todos los clientes del catálogo
    void listarCliente(String nombreCatalogoC);
    
    // Busca el cliente "Buscar" en nuestro catálogo
    void buscarCliente(String nombreCatalogoC, String buscar);
    
    void buscarClienteId(String nombreCatalogoC, int buscar);
    
    // Nos inicia nuestro catálogo
    void iniciarCatalogoC(String nombreCatalogoC);
    
    void borrarC(String nombreCatalogoC, String nombreCliente);
    
    String borrarCatalogoC(String nombreCatalogoC);
}
