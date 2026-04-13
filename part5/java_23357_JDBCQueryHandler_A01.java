import java.sql.*;

public class java_23357_JDBCQueryHandler_A01 {
    // private variables for db credentials
    private String url;
    private String username;
    private String password;

    // constructor to initialize the connection
    public java_23357_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // method to create a connection
    public Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
       
        }
        return connection;
    }

    // method to execute a query
    public void executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Query result: " + resultSet.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("Error in executing query!");
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                System.out.println("Error while closing statement!");
                e.printStackTrace();
            }

            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println("Error while closing connection!");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
        handler.executeQuery("SELECT * FROM Users");
    }
}