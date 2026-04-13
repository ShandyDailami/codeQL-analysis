import java.sql.*;

public class java_27239_JDBCQueryHandler_A01 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public static void main(String[] args) throws SQLException {
        String query = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
        ResultSet resultSet = executeQuery(query);

        if (resultSet.next()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        resultSet.close();
        connection.close();
    }
}