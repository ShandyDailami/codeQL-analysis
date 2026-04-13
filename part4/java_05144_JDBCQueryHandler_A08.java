import java.sql.*;
import java.util.Properties;

public class java_05144_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_05144_JDBCQueryHandler_A08() {
        // Create a properties object to hold database connection parameters
        Properties props = new Properties();

        // Set database connection properties
        props.setProperty("user", "your_username");
        props.setProperty("password", "your_password");
        props.setProperty("useSSL", "false");
        props.setProperty("serverTimezone", "UTC");

        // Set database connection URL
        String url = "jdbc:mysql://localhost:3306/your_database";

        // Establish a connection to the database
        try {
            this.connection = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        // Create a statement object
        Statement statement;

        // Initialize the statement object with the connection object
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        // Execute the query and return the result set
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return resultSet;
    }

    public void executeUpdate(String update) {
        // Create a statement object
        Statement statement;

        // Initialize the statement object with the connection object
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Execute the update
        try {
            statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJavaJDBCQueryHandler handler = new VanillaJavaJDBCQueryHandler();

        // Example of executing a query
        ResultSet resultSet = handler.executeQuery("SELECT * FROM your_table");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("column_name"));
        }

        // Example of executing an update
        handler.executeUpdate("UPDATE your_table SET column1 = 'new_value' WHERE column2 = 'some_value'");
    }
}