import java.sql.*;

public class java_04256_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // CREATE
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Users (" +
                    "ID INT PRIMARY KEY, " +
                    "NAME VARCHAR(50), " +
                    "EMAIL VARCHAR(50))";
            statement.executeUpdate(createTableQuery);

            String insertQuery = "INSERT INTO Users (ID, NAME, EMAIL) VALUES (1, 'John Doe', 'john.doe@example.com')";
            statement.executeUpdate(insertQuery);

            // READ
            String selectQuery = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

            // UPDATE
            String updateQuery = "UPDATE Users SET EMAIL = 'new.email@example.com' WHERE ID = 1";
            statement.executeUpdate(updateQuery);

            // DELETE
            String deleteQuery = "DELETE FROM Users WHERE ID = 1";
            statement.executeUpdate(deleteQuery);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}