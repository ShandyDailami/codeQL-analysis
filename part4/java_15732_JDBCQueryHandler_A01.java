import java.sql.*;

public class java_15732_JDBCQueryHandler_A01 {

    // Creating a connection
    public Connection createConnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Creating a PreparedStatement
    public PreparedStatement createPreparedStatement(Connection connection, String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    // Executing the query and fetching the result
    public ResultSet executeQuery(PreparedStatement statement) throws SQLException {
        return statement.executeQuery();
    }

    // Closing the connection
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    // Closing the statement
    public void closeStatement(PreparedStatement statement) throws SQLException {
        statement.close();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            Connection connection = new JDBCQueryHandler().createConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, "bob");
            ResultSet result = new JDBCQueryHandler().executeQuery(statement);

            while (result.next()) {
                String name = result.getString("username");
                System.out.println("Name: " + name);
            }

            new JDBCQueryHandler().closeConnection(connection);
            new JDBCQueryHandler().closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}