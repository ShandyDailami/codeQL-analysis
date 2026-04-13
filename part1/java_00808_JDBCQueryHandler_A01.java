import java.sql.*;

public class java_00808_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        connectToDB();
        createTable();
        insertData();
        updateData();
        selectData();
        deleteData();
        closeConnection();
    }

    private static void connectToDB() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable() {
        String query = "CREATE TABLE employees (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(50)," +
                "salary DOUBLE)";

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData() {
        String query = "INSERT INTO employees (id, name, salary) VALUES (1, 'John', 5000.0)";

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateData() {
        String query = "UPDATE employees SET name = 'Sam' WHERE id = 1";

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectData() {
        String query = "SELECT * FROM employees";

        try (ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Salary: " + resultSet.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteData() {
        String query = "DELETE FROM employees WHERE id = 1";

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}