import java.sql.*;

public class java_21397_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database!");

            String selectQuery = "SELECT * FROM your_table";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    System.out.println("ID: " + id + ", Name: " + name);
                }
            }

            String insertQuery = "INSERT INTO your_table (name) VALUES ('new_name')";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(insertQuery);
            }

            String updateQuery = "UPDATE your_table SET name = 'new_name' WHERE id = 1";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(updateQuery);
            }

            String deleteQuery = "DELETE FROM your_table WHERE id = 1";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(deleteQuery);
            }

            System.out.println("Operations completed!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database!");
        }
    }
}