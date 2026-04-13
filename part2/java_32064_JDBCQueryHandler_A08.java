import java.sql.*;

public class java_32064_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM A08_IntegrityFailure WHERE id = " + args[0];
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Step 3: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the result
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }

            // Step 5: Close the connection
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}