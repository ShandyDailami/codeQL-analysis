import java.sql.*;

public class java_20918_JDBCQueryHandler_A07 {
    private Connection connection;
    private Statement statement;

    public java_20918_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            ResultSet resultSet = jdbcHandler.executeQuery("SELECT * FROM my_table");

            while (resultSet.next()) {
                // Process the result set here
            }

            jdbcHandler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error handling JDBC connection: " + e.getMessage());
        }
    }
}