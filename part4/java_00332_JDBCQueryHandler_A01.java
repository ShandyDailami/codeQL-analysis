import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_00332_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        List<Employee> employees = getEmployees();
        employees.forEach(System.out::println);
    }

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT id, name FROM Employee";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    employees.add(new Employee(id, name));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
}

class Employee {
    private int id;
    private String name;

    public java_00332_JDBCQueryHandler_A01(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}