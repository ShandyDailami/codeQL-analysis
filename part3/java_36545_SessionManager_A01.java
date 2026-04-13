import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_36545_SessionManager_A01 {
    private DataSource dataSource;

    public java_36545_SessionManager_A01(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("Failed to get connection: " + e.getMessage());
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Here you would typically inject the dataSource via an application context.
        // For the sake of this example, we'll just use a simple DataSource for demonstration purposes.
        DataSource dataSource = new org.apache.commons.dbcp2.BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");

        SessionManager sessionManager = new SessionManager(dataSource);

        Connection connection = sessionManager.getConnection();
        if (connection != null) {
            System.out.println("Connection successfully obtained.");
            sessionManager.closeConnection(connection);
        }
    }
}