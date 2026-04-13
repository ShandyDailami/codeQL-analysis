import java.sql.*;

public class java_02472_JDBCQueryHandler_A07 {
    private Connection connection;
    private Statement statement;

    public java_02472_JDBCQueryHandler_A07(String dbURL, String userName, String password) {
        try {
            connection = DriverManager.getConnection(dbURL, userName, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String update) {
        try {
            statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // replace these values with your actual database connection details
        String dbURL = "jdbc:mysql://localhost:3306/test";
        String userName = "username";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(dbURL, userName, password);

        // Example query
        String query = "SELECT * FROM users WHERE id = ?";
        PreparedStatement preparedStatement = handler.connection.prepareStatement(query);
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = handler.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }

        // Example update
        String update = "UPDATE users SET password = ? WHERE id = ?";
        handler.executeUpdate(update);
    }
}