import java.sql.*;

public class java_30644_JDBCQueryHandler_A01 {
    private Connection connection;
    private String url;
    private String username;
    private String password;

    public java_30644_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Assume the query is a SELECT query
        return statement.executeQuery();
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Connect to the database
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
        handler.connect();

        // Execute a query
        ResultSet result = handler.executeQuery("SELECT * FROM users");

        // Print the results
        try {
            while (result.next()) {
                System.out.println("User ID: " + result.getInt("id"));
                System.out.println("User Name: " + result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Close the connection
        handler.close();
    }
}