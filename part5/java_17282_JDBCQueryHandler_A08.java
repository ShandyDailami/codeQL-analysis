import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_17282_JDBCQueryHandler_A08 {

    // Load the driver
    static {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    // Execute a query
    public void executeQuery(String query) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "username", "password");
                     Statement statement = connection.createStatement()) {

                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        System.out.println("Result: " + resultSet.getString("name"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}