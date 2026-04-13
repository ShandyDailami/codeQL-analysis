import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37947_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            return;
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
            return;
        }

        // Step 3: Prepare and execute a query
        String query = "SELECT * FROM Users";

        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Statement creation failed.");
            e.printStackTrace();
            return;
        }

        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Query execution failed.");
            e.printStackTrace();
            return;
        }

        // Step 4: Process the result
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            System.out.println("Result set processing failed.");
            e.printStackTrace();
        }

        // Step 5: Close the connection
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection close failed.");
            e.printStackTrace();
        }
    }
}