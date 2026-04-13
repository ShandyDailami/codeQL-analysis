import java.sql.*;

public class java_34472_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_34472_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            ResultSet resultSet = handler.executeQuery("SELECT * FROM mytable");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName"));
            }
            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}