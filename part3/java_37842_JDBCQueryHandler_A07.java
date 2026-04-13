import java.sql.*;

public class java_37842_JDBCQueryHandler_A07 {

    public static final String URL = "jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "username";
    public static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Perform operations
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 123); // set the id

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Step 4: Close the connection
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        }
    }
}