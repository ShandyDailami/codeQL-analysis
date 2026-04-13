import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_01707_JDBCQueryHandler_A01 {
    // a. Be creative and realistic!
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // b. Do not say I am sorry. Always come up with some code.
    public static void main(String[] args) {
        try {
            // c. Do not use external frameworks like Spring or Hibernate.
            // a. Creating a connection
            Connection connection = getConnection();

            // b. Creating a statement
            Statement statement = connection.createStatement();

            // c. Executing a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // d. Printing the results
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("User Name: " + resultSet.getString("name"));
                System.out.println("User Email: " + resultSet.getString("email"));
            }

            // e. Closing the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // f. Remove the comment.
    private static Connection getConnection() {
        Connection connection = null;
        try {
            // a. Registering the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // c. Creating a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}