import java.sql.*;

public class java_28577_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_28577_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column1") + " - " + resultSet.getString("column2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");
        queryHandler.executeQuery("SELECT * FROM your_table");
    }
}