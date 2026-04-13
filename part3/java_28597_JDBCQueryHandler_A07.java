import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28597_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // Load MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        // Connect to the database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");

            // Execute a SELECT query
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");) {
                    while (rs.next()) {
                        System.out.println(rs.getString("column_name"));
                    }
                }
            }

            System.out.println("Disconnected from database");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}