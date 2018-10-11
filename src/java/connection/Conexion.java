package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luis
 */
public class Conexion {

    public static Connection Cont;
    static String Driver = "com.mysql.jdbc.Driver";
    //static String User = "luisgeraldo";
    static String User = "root";
    //static String Password = "Rviadatabase23";
    static String Password = "1234";
    //static String Url = "jdbc:mysql://sql3.freesqldatabase.com/sql3230022";
    static String Url = "jdbc:mysql://localhost:3306/srsdb?zeroDateTimeBehavior=convertToNull";

    public Conexion() {
        Cont = null;

        try {
            Class.forName(Driver);

            Cont = DriverManager.getConnection(Url, User, Password);

            if (Cont != null) {
                System.out.println("Conexion establecida");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrio un error al conectarse" + e);
        }
    }

    public Connection getConexion() {
        return Cont;
    }

    public static void main(String args[]) {
        Conexion CC = new Conexion();
       
        
    }

    
    
}
