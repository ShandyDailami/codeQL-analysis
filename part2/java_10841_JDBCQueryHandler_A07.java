import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_10841_JDBCQueryHandler_A07 {

    private Connection connection;
    private Statement statement;

    public java_10841_JDBCQueryHandler_A07(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    public boolean authenticate(String username, String password) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username ='" + username + "' and password='" + password + "'");
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

}