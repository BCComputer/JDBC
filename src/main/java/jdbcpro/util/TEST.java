package jdbcpro.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TEST {


public static Connection getConnection() {
    Connection con=null;
    String databaseName = "highschool";
    String url = "jdbc:mysql://localhost:3306"+databaseName;
    String userName = "root";
    String password = "1234";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, userName, password);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    return con;
}
}
