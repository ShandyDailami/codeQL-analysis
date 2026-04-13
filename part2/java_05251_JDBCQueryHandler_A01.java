import java.sql.*;

public class java_05251_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:h2:mem:testdb";
        String username = "sa";
        String password = "";

        // Establish connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection established!");

            // Execute SQL query
            String sql = "CREATE TABLE Employees (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "salary INT)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            // Insert data
            sql = "INSERT INTO Employees (id, name, salary) VALUES (1, 'John', 50000)";
            statement.executeUpdate(sql);

            // Fetch data
            sql = "SELECT * FROM Employees";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int salary = resultSet.getInt(3);
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}