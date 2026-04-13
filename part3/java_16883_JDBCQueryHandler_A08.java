import java.sql.*;

public class java_16883_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;

    public java_16883_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
            ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}