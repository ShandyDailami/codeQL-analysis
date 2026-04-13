import java.sql.*;

public class java_19766_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_19766_JDBCQueryHandler_A08(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Set up the connection parameters
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "myuser";
        String password = "mypassword";

        // Create a new instance of the JDBCQueryHandler
        JDBCQueryHandler handler = new JDBCQueryHandler(url, user, password);

        // Execute a query
        String query = "SELECT name FROM mytable WHERE name = 'myname'";
        handler.executeQuery(query);
    }
}