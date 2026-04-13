import java.sql.*;

public class java_10236_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_10236_JDBCQueryHandler_A03(String url, String username, String password) {
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

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Setup connection information
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        // Create instance of JDBCQueryHandler
        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        // Execute a query
        handler.executeQuery("SELECT * FROM Users");
    }
}