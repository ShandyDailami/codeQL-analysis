import java.sql.*;

public class java_01895_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/db_name";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Assuming we have a table named 'users' and we want to insert a new user
            String insertUserQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertUserQuery);
            insertStatement.setString(1, "newUser");
            insertStatement.setString(2, "hashedPassword");
            insertStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}