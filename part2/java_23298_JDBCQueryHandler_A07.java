import java.sql.*;

public class java_23298_JDBCQueryHandler_A07 {

    private static final String JDBC_URL = "your_jdbc_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM your_table"; // replace with your table name
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 3: Execute the statement
            ResultSet result = statement.executeQuery();

            // Step 4: Process the results
            while (result.next()) {
                // This is a dummy operation, replace with your actual operation
                String username = result.getString("username");
                String password = result.getString("password");
                if (isPasswordWeak(password)) {
                    System.out.println("Found weak password for user: " + username);
                }
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // This is a dummy function, replace with your actual function to check if a password is weak
    private static boolean isPasswordWeak(String password) {
        return password.length() < 8; // replace with your actual check
    }
}