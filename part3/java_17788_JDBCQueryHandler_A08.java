import java.sql.*;

public class java_17788_JDBCQueryHandler_A08 {
    private String url;
    private String user;
    private String password;

    public java_17788_JDBCQueryHandler_A08(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Print out the result of each row
                System.out.println("ID: " + resultSet.getInt("ID"));
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Email: " + resultSet.getString("Email"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Replace with your actual database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "myusername";
        String password = "mypassword";

        // Create a new instance of the JDBCQueryHandler
        JDBCQueryHandler handler = new JDBCQueryHandler(url, user, password);

        // Execute a query
        handler.executeQuery("SELECT * FROM Users");
    }
}