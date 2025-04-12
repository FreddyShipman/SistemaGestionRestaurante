package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author janot
 */
/**
 * Clase encargada de gestionar la conexión con la base de datos utilizando JDBC.
 * Esta clase proporciona un método estático para obtener una conexión a la base de datos.
 */
public class ConexionConJDBC {

    /**
     * Obtiene una conexión a la base de datos MySQL utilizando JDBC.
     * 
     * @return La conexión establecida con la base de datos.
     * @throws SQLException Si ocurre un error al intentar obtener la conexión con la base de datos.
     */
    public static Connection obtenerConexion() throws SQLException {
        // URL de la base de datos MySQL
        String url = "jdbc:mysql://localhost:3306/restaurante";
        
        // Credenciales de la base de datos
        String usuario = "root";
        String contraseña = "12345678";

        // Establece y devuelve la conexión a la base de datos
        return DriverManager.getConnection(url, usuario, contraseña);
    }
}