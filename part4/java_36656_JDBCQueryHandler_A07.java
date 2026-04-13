import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_36656_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname"; // replace with your actual url
        String username = "username"; // replace with your actual username
        String password = "password"; // replace with your actual password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM your_table"; // replace with your actual query

            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        System.out.println(rs.getString("column_name")); // replace "column_name" and "your_table" with your actual column name and table name
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database: " + e.getMessage());
        }
    }
}