import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_02614_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming you're using MySQL
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/testdb?useSSL=false&verifyServerCertificate=false",
                "username", "password")) {

            // Step 3: Prepare and execute a query
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM users WHERE username = 'testuser' AND password = 'testpassword'";
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    if (resultSet.next()) {
                        System.out.println("User found!");
                    } else {
                        System.out.println("User not found!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}