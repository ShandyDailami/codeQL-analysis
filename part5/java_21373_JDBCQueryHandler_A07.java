import java.sql.*;

public class java_21373_JDBCQueryHandler_A07 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            connection.setAutoCommit(false); // Disable auto commit, since we'll manually commit our changes

            // Step 2: Prepare the statement
            statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, "admin");

            // Step 3: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Step 4: Handle the result set
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                if (password.equals("securepassword")) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            }

            // Step 5: Close the statement and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}