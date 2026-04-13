import java.sql.*;

public class java_21888_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            String query = "SELECT * FROM Employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}