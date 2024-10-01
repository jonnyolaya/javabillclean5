package conexbillclean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class conexionbillclean2  {
    public static void main(String[] args) {
        // URL de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/almacen";
        String user = "root";
        String password = "";
        try {
            try ( // Establecer la conexión
                    Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("Conexión establecida.");
                
            

                // Ejecutar una consulta
                try ( // Crear una declaración
                        Statement stmt = conn.createStatement(); // Ejecutar una consulta
                        ResultSet rs = stmt.executeQuery("SELECT * FROM inventario")) {
                    
                    // Procesar los resultados
                    while (rs.next()) {
                        System.out.println(rs.getString("idproducto")+""+rs.getString("nombreproducto")+""+rs.getString("cantidad")+""+rs.getString("precio")+""+rs.getString("fecha ingreso"));
                    }
                    
                }
            }
           
        } catch (SQLException e) {
        }
        
    }
}