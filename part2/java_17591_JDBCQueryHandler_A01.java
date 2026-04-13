import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17591_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_17591_JDBCQueryHandler_A01(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
        this.statement = this.connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return this.statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (this.statement != null) {
            this.statement.close();
        }

        if (this.connection != null) {
            this.connection.close();
        }
    }
}