import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_17851_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, "admin"); // admin is a malicious username
            
            // Execute the query
            statement.execute();
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}