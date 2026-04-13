import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_41519_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_41519_SessionManager_A03() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.execute("CREATE DATABASE test");
        sessionManager.execute("CREATE TABLE test (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100))");
        sessionManager.execute("INSERT INTO test (name) VALUES ('John')");
        sessionManager.execute("INSERT INTO test (name) VALUES ('Jane')");
    }
}