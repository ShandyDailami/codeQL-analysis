import java.sql.*;

public class java_32952_JDBCQueryHandler_A08 {
    // Database credentials
    private String url;
    private String username;
    private String password;

    // Connection object
    private Connection conn;

    // JDBC driver name
    private String driver;

    public java_32952_JDBCQueryHandler_A08(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void establishConnection() {
        try {
            // Load the driver
            Class.forName(driver);

            // Establish the connection
            conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connection successful");
        } catch (Exception e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while closing connection");
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error while executing query");
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error while executing update");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Define database connection details
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        // Create a connection handler
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(driver, url, username, password);

        // Establish connection
        jdbcQueryHandler.establishConnection();

        // Execute a query
        ResultSet rs = jdbcQueryHandler.executeQuery("SELECT * FROM users");

        // Process the result set
        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("Name: " + name + ", Age: " + age);
        }

        // Close connection
        jdbcQueryHandler.closeConnection();
    }
}