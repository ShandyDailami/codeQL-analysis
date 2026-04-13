import java.sql.*;
import java.util.Properties;

public class java_02590_JDBCQueryHandler_A07 {
    private Connection connection;
    private Statement statement;

    public java_02590_JDBCQueryHandler_A07() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "password");
        props.setProperty("useSSL", "false");
        props.setProperty("autoReconnect", "true");
        props.setProperty("characterEncoding", "utf8");
        props.setProperty("connectTimeout", "5000");
        props.setProperty("socketTimeout", "5000");
        props.setProperty("rewriteBatchedStatements", "true");
        props.setProperty("rewriteQuotedIdentifiers", "false");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", props);
            statement = connection.createStatement();
        } catch (Exception e) {
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

    public int executeUpdate(String query) {
        int updateCount = 0;
        try {
            updateCount = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateCount;
    }

    public void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}