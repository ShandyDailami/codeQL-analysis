import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35151_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            String sql = "SELECT * FROM employees WHERE id = " + connection.prepareStatement("SELECT id FROM employees WHERE id = " + args[0]);

            connection.prepareStatement(sql).execute();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }
}