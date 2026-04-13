import java.sql.*;

public class java_22805_JDBCQueryHandler_A01 {

    private String url;
    private String username;
    private String password;

    public java_22805_JDBCQueryHandler_A01(String url, String username, String password) {
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
                // Print the result
                System.out.println(resultSet.getString("columnName"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // In a real application, you would typically use a configuration file to provide the database credentials
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/db", "username", "password");
        handler.executeQuery("SELECT * FROM table");
    }
}