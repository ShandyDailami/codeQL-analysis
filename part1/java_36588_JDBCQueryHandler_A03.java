import java.sql.*;

public class java_36588_JDBCQueryHandler_A03 {
    private Connection connection;
    private Statement statement;

    public java_36588_JDBCQueryHandler_A03(String dbUrl, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, password);
        this.statement = connection.createStatement();
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