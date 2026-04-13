import java.sql.*;

public class java_09196_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "myUser";
    private static final String password = "myPassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM myTable WHERE column = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            pstmt.setString(1, "myValue");

            // Step 4: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the ResultSet
            while (rs.next()) {
                System.out.println("Found a row in the database with value: " + rs.getString("column"));
            }

            // Step 6: Close the connection
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in JDBC operations: " + e.getMessage());
        }
    }
}