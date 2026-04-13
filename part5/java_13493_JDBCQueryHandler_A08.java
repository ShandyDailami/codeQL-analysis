import java.sql.*;

public class java_13493_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_13493_JDBCQueryHandler_A08(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");

            ResultSet resultSet = handler.executeQuery("SELECT * FROM your_table");

            while (resultSet.next()) {
                // Your code here to handle the result set
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}