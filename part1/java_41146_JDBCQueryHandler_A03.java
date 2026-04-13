import java.sql.*;

public class java_41146_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Open a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Perform a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            // Step 4: Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Cleanup
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}