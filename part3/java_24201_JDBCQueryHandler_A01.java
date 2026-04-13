import java.sql.*;

public class java_24201_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_24201_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try {
            // Create a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement from the connection
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Print the results
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}