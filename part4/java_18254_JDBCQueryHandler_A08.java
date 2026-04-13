import java.sql.*;

public class java_18254_JDBCQueryHandler_A08 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";

    private SecurityManager securityManager;

    public java_18254_JDBCQueryHandler_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // process the result set
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            securityManager.fireSecurityEvent("IntegrityFailure", "Failed to execute query: " + query);
            // handle the exception or report the failure
        }
    }
}