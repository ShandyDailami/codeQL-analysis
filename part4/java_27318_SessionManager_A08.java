import java.sql.*;

public class java_27318_SessionManager_A08 {
    private static SessionManager instance = null;

    private java_27318_SessionManager_A08() {}

    public static SessionManager getInstance() {
        if(instance == null) {
            instance = new SessionManager();
        }

        return instance;
    }

    private Connection connection = null;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/db", "username", "password");
        }

        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public void performOperation(String query) {
        try {
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // perform operations here
            }

            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}