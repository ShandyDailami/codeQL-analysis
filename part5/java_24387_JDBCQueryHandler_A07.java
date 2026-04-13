import java.sql.*;

public class java_24387_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_24387_JDBCQueryHandler_A07(String url, String username, String password) {
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
                System.out.println(resultSet.getString("name"));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Add your URL, username, and password here
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        handler.executeQuery("SELECT * FROM Users");
    }
}