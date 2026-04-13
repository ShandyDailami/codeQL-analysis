import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12310_SessionManager_A08 {
    private Connection connection;

    public void openSession() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testDB?useSSL=false", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}