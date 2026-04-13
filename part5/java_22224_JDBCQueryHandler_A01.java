import java.sql.*;

public class java_22224_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_22224_JDBCQueryHandler_A01(String dbUrl, String userName, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, userName, password);
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}