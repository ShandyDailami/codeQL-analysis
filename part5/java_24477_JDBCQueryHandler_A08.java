import java.sql.*;

public class java_24477_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            // Example: Query for all employees who have a salary more than 5000
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE salary > 5000");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}