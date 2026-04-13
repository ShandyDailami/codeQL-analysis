import java.sql.*;

public class java_30801_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connectDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectDatabase() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to database");

            String selectQuery = "SELECT * FROM employees";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        double salary = resultSet.getDouble("salary");

                        System.out.println("ID: " + id);
                        System.out.println("Name: " + name);
                        System.out.println("Salary: " + salary);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to database");
            e.printStackTrace();
        }
    }
}