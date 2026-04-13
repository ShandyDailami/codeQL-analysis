import java.sql.*;

public class java_09840_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM my_table";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Record 1: ID = " + resultSet.getString("ID"));
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database.");
        }
    }
}