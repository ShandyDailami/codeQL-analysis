import java.sql.*;

public class java_37851_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_37851_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("url", "username", "password");
        jdbcHandler.executeQuery("SELECT * FROM table_name");
    }
}