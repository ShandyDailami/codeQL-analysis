import java.sql.*;

public class java_37025_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");

                // Check if integrity of data (e.g., negative salary, null name, etc.)
                if (salary < 0) {
                    throw new IllegalArgumentException("Salary cannot be negative");
                }
                if (name == null || name.isEmpty()) {
                    throw new IllegalArgumentException("Name cannot be null or empty");
                }

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
                System.out.println("--------------------");
            }

            connection.close();

        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}