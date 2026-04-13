import java.sql.*;

public class java_14398_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String insertUserSQL = "INSERT INTO users (username, password) VALUES (?, Bcrypt(?))";
            PreparedStatement statement = connection.prepareStatement(insertUserSQL);

            // Step 4: Set parameters
            statement.setString(1, "newuser");
            statement.setString(2, "password");

            // Step 5: Execute the statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully.");
            }

            // Step 6: Close the connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}