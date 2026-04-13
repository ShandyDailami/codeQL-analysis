import java.sql.*;

public class java_32606_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL Query
            String query = "SELECT * FROM Employees";
            Statement statement = connection.createStatement();

            // Step 4: Execute Query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the Result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}