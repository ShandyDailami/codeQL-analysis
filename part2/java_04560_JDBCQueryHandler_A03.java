import java.sql.*;

public class java_04560_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_04560_JDBCQueryHandler_A03(String dbURL, String userName, String password) {
        try {
            connection = DriverManager.getConnection(dbURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean executeNonQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return (result > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}