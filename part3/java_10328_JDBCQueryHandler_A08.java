import java.sql.*;

public class java_10328_JDBCQueryHandler_A08 {
    public static final String URL = "jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute the SQL query
            String sql = "UPDATE user SET password = 'newpassword' WHERE id = 1";
            statement.executeUpdate(sql);

            // Step 4: Handle the result
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE id = 1");
            while (resultSet.next()) {
                System.out.println("User id: " + resultSet.getInt("id"));
            }

            // Step 5: Clean up
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}