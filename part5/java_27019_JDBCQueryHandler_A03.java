import java.sql.*;

public class java_27019_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Example of a SQL Injection Vulnerability
            String usernameToCheck = args[0]; // args[0] is the user input
            String query = "SELECT * FROM users WHERE username = '" + usernameToCheck + "'";

            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}