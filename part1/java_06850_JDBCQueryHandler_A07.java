import java.sql.*;

public class java_06850_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
                jdbcQueryHandler.processQuery(connection);
            } else {
                System.out.println("Failed to establish a connection with the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void processQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "user1");
        preparedStatement.setString(2, "password1");
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}