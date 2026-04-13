import java.sql.*;

public class java_02027_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_02027_JDBCQueryHandler_A08(String url, String username, String password) {
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
                // Process each row here
                System.out.println(resultSet.getString("column_name"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_db_url", "username", "password");
        handler.executeQuery("SELECT * FROM your_table");
    }
}