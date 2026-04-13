import java.sql.*;

public class java_18225_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM employees");

            // Step 5: Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}