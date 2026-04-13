import java.sql.*;

public class java_37883_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Step 1: Establish a connection
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to database!");

            // Step 2: Prepare a statement
            String query = "SELECT * FROM table_name WHERE condition";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Step 3: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Step 5: Close the statement and connection
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database or executing query: " + e.getMessage());
        }
    }
}