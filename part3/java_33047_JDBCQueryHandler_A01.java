import java.sql.*;

public class java_33047_JDBCQueryHandler_A01 {

    private String driver;
    private String url;
    private String username;
    private String password;

    public java_33047_JDBCQueryHandler_A01(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the database driver
            Class.forName(driver);

            // Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Create a statement object
            statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                // Access the data in the result set
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");

                // Do something with the data
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}