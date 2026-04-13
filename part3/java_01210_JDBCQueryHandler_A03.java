import java.sql.*;

public class java_01210_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // Please replace with your actual password

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String SQL = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, "admin"); // Username of an existing user

            // Step 3: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result
            while (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (checkPassword(dbPassword)) {
                    System.out.println("Access granted for user: " + resultSet.getString("username"));
                } else {
                    System.out.println("Access denied for user: " + resultSet.getString("username"));
                }
            }

            // Step 5: Clean up
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkPassword(String password) {
        // Here you can add your password check logic
        // For now, let's just return true for simplicity
        return true;
    }
}