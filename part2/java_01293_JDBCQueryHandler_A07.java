import java.sql.*;

public class java_01293_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_01293_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query, String... parameters) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters
            for (int i = 0; i < parameters.length; i++) {
                statement.setString(i + 1, parameters[i]);
            }

            // Execute query
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void executeUpdate(String query, String... parameters) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters
            for (int i = 0; i < parameters.length; i++) {
                statement.setString(i + 1, parameters[i]);
            }

            // Execute update
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}