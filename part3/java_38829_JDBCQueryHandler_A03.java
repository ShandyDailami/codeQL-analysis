import java.sql.*;

public class java_38829_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        // Connect to the database
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            // Create a statement
            try (Statement stmt = con.createStatement()) {
                // Execute a query
                ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

                // Process the results
                while (rs.next()) {
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println(name + ", " + age);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}