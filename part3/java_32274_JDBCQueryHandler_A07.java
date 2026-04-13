import java.sql.*;

public class java_32274_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // 1. Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            // 4. Process the result
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }

            // 5. Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}