import java.sql.*;

public class java_09311_JDBCQueryHandler_A01 {

    private String url;
    private String username;
    private String password;

    public java_09311_JDBCQueryHandler_A01(String url, String username, String password) {
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
                // process the result set
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a JDBCQueryHandler instance
        // You should ideally not hard code the url, username, and password here, but for the sake of this example, we'll use some default values
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "myuser", "mypassword");

        // Execute a query
        handler.executeQuery("SELECT * FROM mytable");
    }
}