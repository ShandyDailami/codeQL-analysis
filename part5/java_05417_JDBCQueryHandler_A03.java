import java.sql.*;

public class java_05417_JDBCQueryHandler_A03 {
    private static String url;
    private static String username;
    private static String password;

    // static block for setting up the connection
    static {
        try {
            url = "jdbc:mysql://localhost:3306/mydatabase";
            username = "myuser";
            password = "mypassword";

            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a simple SELECT query
    public void executeSelectQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            // Print the result
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a simple INSERT query
    public void executeInsertQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Execute the query
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a simple DELETE query
    public void executeDeleteQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Execute the query
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a simple UPDATE query
    public void executeUpdateQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Execute the query
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}