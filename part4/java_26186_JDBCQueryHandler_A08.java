import java.sql.*;

public class java_26186_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_26186_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
   
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password");

        try {
            ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            handler.executeUpdate("INSERT INTO Users (username, password) VALUES ('testuser', 'testpassword')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}