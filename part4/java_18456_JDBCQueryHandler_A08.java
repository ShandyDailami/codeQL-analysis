import java.sql.*;

public class java_18456_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            // Example of a SQL injection vulnerability
            String query = "SELECT * FROM users WHERE username='" + args[0] + "' and password='" + args[1] + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("Found user!");
            } else {
                System.out.println("No user found!");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database: " + e.getMessage());
        }
    }
}