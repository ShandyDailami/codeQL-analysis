import java.sql.*;

public class java_03799_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_03799_JDBCQueryHandler_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL Driver
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            this.statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
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

    public void executeUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}