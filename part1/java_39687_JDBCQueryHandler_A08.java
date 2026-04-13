import java.sql.*;

public class java_39687_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // Step 2: Create a statement object
            Statement statement = connection.createStatement();
            
            // Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            
            // Step 4: Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
            
            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}