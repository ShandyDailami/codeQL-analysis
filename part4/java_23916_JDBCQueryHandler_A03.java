import java.sql.*;

public class java_23916_JDBCQueryHandler_A03 {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    // Constructor to initialize the connection
    public java_23916_JDBCQueryHandler_A03() {
        try {
            connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a SELECT query
    public ResultSet executeQuery(String query) {
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Method to execute a SELECT query, using a parameterized query
    public ResultSet executeQuery(String query, Object... parameters) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Method to execute an INSERT, UPDATE, or DELETE query
    public void executeUpdate(String query, Object... parameters) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}