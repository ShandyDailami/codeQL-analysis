import java.sql.*;

public class java_10700_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_10700_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean validateAccess() {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Run a simple query to check if the connection was successful
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT 1");
            resultSet.close();

            // Step 3: Close the connection
            connection.close();

            // Step 4: If the connection was successful, return true
            return true;
        } catch (SQLException e) {
            // Step 5: If the connection failed, return false
            return false;
        }
    }
}