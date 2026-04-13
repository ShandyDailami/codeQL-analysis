import java.sql.*;

public class java_31986_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // Replace with your DB URL
        String username = "username"; // Replace with your username
        String password = "password"; // Replace with your password

        try {
            // Step 1: Register the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a Query
            String query = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

            // Step 5: Close the Connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}