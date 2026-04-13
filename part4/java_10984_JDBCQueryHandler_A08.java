import java.sql.*;

public class java_10984_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_10984_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        connection.close();
        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        connection.close();
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "myuser", "mypassword");
        try {
            ResultSet resultSet = handler.executeQuery("SELECT * FROM mytable");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("mycolumn"));
            }
            handler.executeUpdate("UPDATE mytable SET mycolumn = 'newvalue' WHERE mycolumn = 'oldvalue'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}