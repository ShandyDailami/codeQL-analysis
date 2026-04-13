import java.sql.*;

public class java_36046_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            String selectQuery = "SELECT * FROM employees";
            try (Statement statement = conn.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double salary = resultSet.getDouble("salary");
                    System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
                }
            }

            String insertQuery = "INSERT INTO employees (name, salary) VALUES ('John', 50000.0)";
            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(insertQuery);
            }

            String updateQuery = "UPDATE employees SET salary = 60000.0 WHERE name = 'John'";
            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(updateQuery);
            }

            String deleteQuery = "DELETE FROM employees WHERE name = 'John'";
            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(deleteQuery);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}