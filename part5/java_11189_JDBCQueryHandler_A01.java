import java.sql.*;

public class java_11189_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_11189_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        JDBCQueryHandler queryHandler = new JDBCQueryHandler(url, username, password);

        try {
            ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            queryHandler.executeUpdate("UPDATE Users SET password = 'new_password' WHERE username = 'username'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}