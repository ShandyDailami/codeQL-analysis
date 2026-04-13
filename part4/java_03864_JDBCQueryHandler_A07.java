import java.sql.*;

public class java_03864_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_03864_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean authFailure() {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Open a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT 1 FROM dual");

            // Check if there is a row in the result set
            if (resultSet.next()) {
                // The query was successful
                return false;
            } else {
                // The query failed
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}