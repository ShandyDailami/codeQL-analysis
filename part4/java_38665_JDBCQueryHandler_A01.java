import java.sql.*;

public class java_38665_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_38665_JDBCQueryHandler_A01(String dbURL, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "root");
            ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
            jdbcQueryHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}