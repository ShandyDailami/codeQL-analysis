import java.sql.*;

public class java_11742_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Register MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare Statement
            Statement statement = connection.createStatement();

            // Step 4: Execute SQL Query
            String sql = "SELECT * FROM users WHERE username='test' AND password='test'";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Handle Result
            while (resultSet.next()) {
                System.out.println("User Found!");
            }

            // Step 6: Close Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}