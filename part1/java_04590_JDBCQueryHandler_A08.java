import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_04590_JDBCQueryHandler_A08 {

    private Connection connection;
    private Statement statement;

    public java_04590_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
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
        try {
            new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password")
                    .executeQuery("SELECT * FROM Employees WHERE Id = '1' AND password = '123'");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password").closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}