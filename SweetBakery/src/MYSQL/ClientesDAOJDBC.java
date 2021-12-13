package MYSQL;

import java.sql.SQLException;
import java.util.List;
import sweetbakery.dominio.Cliente;

public class ClientesDAOJDBC implements ClientesDAO{
    
    private static final String SQL_SELECT = "SELECT * FROM cliente";
    private static final String SQL_ORDENAR = "SELECT * FROM cliente ORDER BY idcliente";
    private static final String SQL_INSERT = "INSERT INTO cliente"
            + "(dni,nombre,apellido,correo,telefono,usuario,contrasena) VALUES "
            + "(?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE cliente SET "
            + "correo = ?, "
            + "telefono = ?, "
            + "usuario = ?, "
            + "contrasena = ?  "
            + "WHERE dni = ?";
    
    private static final String SQL_BUSCAR = "SELECT * FROM cliente WHERE usuario='?' AND dni='?'";

    
    private static final String SQL_DELETE = "DELETE FROM cliente  "
            + "WHERE dni = ? ";

    @Override
    public int actualizar(Cliente cliente) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> OdenarID() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Cliente cliente) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borrarporId(Cliente clientes) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscarUsuario(String usuario, String contrasena) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
