package jdbcpro.util;

import acolyte.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {

    public static Connection createConnection(){
        Connection con = null; //This represents a physical connection to a database.

        final String DB_NAME = "highschool";
        final String DB_URL= "jdbc:mysql://localhost:3306/" + DB_NAME;

        final String DB_USERNAME = "root";
        final String DB_PASSWORD = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // To get driver -- mysql-connector-j
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD); //create a connection to a database
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


       return con;
    }
}
