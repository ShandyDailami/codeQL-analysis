import java.sql.*;

public class java_23233_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Prepare a statement
            stmt = conn.createStatement();

            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // Step 5: Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}