import java.sql.*;

public class java_17022_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_17022_JDBCQueryHandler_A01(String dbURL, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, userName, password);
        statement = connection.createStatement();
    }

    public void executeQuery(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("result"));
        }
        resultSet.close();
    }

    public void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/testdb";
        String userName = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(dbURL, userName, password);
            handler.executeQuery("SELECT * FROM users");
            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}