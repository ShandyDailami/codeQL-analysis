import java.sql.*;

public class java_07913_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Setting values
            preparedStatement.setString(1, "user1");
            preparedStatement.setString(2, "password1");

            // Executing query
            int rowsInserted = preparedStatement.executeUpdate();

            System.out.println("Rows inserted: " + rowsInserted);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connection or query execution: " + e.getMessage());
        }
    }
}