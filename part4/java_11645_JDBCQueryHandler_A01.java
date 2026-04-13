import java.sql.*;

public class java_11645_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully!");

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT ID, Name FROM Students";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Step 3: Process the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 4: Cleanup
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Disconnected from the database successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while connecting to the database or executing query: " + e.getMessage());
        }
    }
}