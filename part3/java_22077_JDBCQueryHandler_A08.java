import java.sql.*;

public class java_22077_JDBCQueryHandler_A08 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public void performQuery() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name");

            while (resultSet.next()) {
                // Process the result set here
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while performing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new VanillaJavaJDBCQueryHandler().performQuery();
    }
}