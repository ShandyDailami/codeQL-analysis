import java.sql.*;

public class java_10201_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Open a connection
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Prepare a statement
            try (Statement stmt = con.createStatement()) {
                // Execute the query
                ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

                // Process the result
                while (rs.next()) {
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}