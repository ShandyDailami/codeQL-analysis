import java.sql.*;

public class java_12128_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM tableName WHERE columnName = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            pstmt.setString(1, "value");

            // Step 4: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the result
            while (rs.next()) {
                String columnValue = rs.getString("columnName");
                System.out.println("Column value: " + columnValue);
            }

            // Step 6: Close the statement and connection
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}