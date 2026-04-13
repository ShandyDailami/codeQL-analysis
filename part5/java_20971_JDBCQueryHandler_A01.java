import java.sql.*;
import java.util.Properties;

public class java_20971_JDBCQueryHandler_A01 {

    public static void main(String[] args) {

        // Create a properties object to hold our database connection details
        Properties props = new Properties();

        // Set database connection properties
        props.setProperty("user", "username");
        props.setProperty("password", "password");
        props.setProperty("useSSL", "false");
        props.setProperty("serverTimezone", "UTC");

        // Set database connection URL
        props.setProperty("connectionPoolName", "ExampleConnectionPool");
        props.setProperty("port", "3306");
        props.setProperty("socketTimeout", "10000");
        props.setProperty("characterEncoding", "utf8");

        // Set database connection URL
        props.setProperty("useAffectedRows", "true");
        props.setProperty("rewriteBatchedStatements", "false");
        props.setProperty("maintainTimeStats", "false");

        String databaseUrl = "jdbc:mysql://hostname:port/dbname";

        // Create the connection to the database
        try (Connection connection = DriverManager.getConnection(databaseUrl, props)) {

            // Create the statement object
            try (Statement statement = connection.createStatement()) {

                // Create the result set
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table")) {

                    // Process the result set
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("your_column_name"));
                    }

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}