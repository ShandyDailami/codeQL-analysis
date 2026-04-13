import java.sql.*;

public class java_15376_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:test.db"; // SQLite database
        String selectQuery = "SELECT * FROM Employees"; // SQL query

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");

                System.out.println("id = " + id);
                System.out.println("name = " + name);
                System.out.println("salary = " + salary);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}