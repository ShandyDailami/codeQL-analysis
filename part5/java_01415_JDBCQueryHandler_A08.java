import java.sql.*;

public class java_01415_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        // Open a connection
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Create a statement
            try (Statement stmt = con.createStatement()) {
                // Define a SQL query
                String sql = "SELECT * FROM A08_IntegrityFailure";

                // Execute the query
                ResultSet rs = stmt.executeQuery(sql);

                // Process the result set
                while (rs.next()) {
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String address = rs.getString("address");

                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Address: " + address);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}