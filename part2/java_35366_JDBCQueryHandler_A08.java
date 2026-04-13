import java.sql.*;

public class java_35366_JDBCQueryHandler_A08 {

    private static final String URL = "your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection connection;

    public java_35366_JDBCQueryHandler_A08() {
        this.connection = null;
    }

    public void connect() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Disconnection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                connect();
            }

            PreparedStatement statement = this.connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Query execution failed: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                connect();
            }

            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update execution failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}