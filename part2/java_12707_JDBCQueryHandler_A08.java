import java.sql.*;

public class java_12707_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public java_12707_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            this.resultSet = this.statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.resultSet;
    }

    public void executeUpdate(String query) {
        try {
            this.statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (this.resultSet != null) {
                this.resultSet.close();
            }
            if (this.statement != null) {
                this.statement.close();
            }
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}