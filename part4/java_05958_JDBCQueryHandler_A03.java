import java.sql.*;

public class java_05958_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 1: Prepare Statement
            String query = "SELECT * FROM my_table";
            Statement statement = connection.createStatement();

            // Step 2: Execute Query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 3: Process ResultSet
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            // Step 4: Clean Up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}