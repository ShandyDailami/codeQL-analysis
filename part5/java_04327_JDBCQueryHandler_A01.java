import java.sql.*;

public class java_04327_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:test.db";
        String selectQuery = "SELECT * FROM Employee";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {

            // Print all the employees
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                System.out.println("id = " + id);
                System.out.println("name = " + name);
                System.out.println("department = " + department);
                System.out.println("salary = " + salary);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}