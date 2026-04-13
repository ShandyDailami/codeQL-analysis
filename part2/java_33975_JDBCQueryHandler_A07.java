import java.sql.*;

public class java_33975_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_33975_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void authenticate() {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // Check if the connection is successful
            if (connection.isValid()) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection failed!");
            }
            
            // Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password").authenticate();
    }
}