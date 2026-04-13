import java.sql.*;

public class java_15650_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/db_example";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // step 1: establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // step 2: create a statement
            Statement statement = connection.createStatement();

            // step 3: execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = 'test' AND password = 'test'");

            // step 4: process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // step 5: close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}