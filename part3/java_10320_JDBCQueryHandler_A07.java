import java.sql.*;
import java.util.Properties;

public class java_10320_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            props.setProperty("useSSL", "false");
            props.setProperty("verifyServerCertificate", "false");
            props.setProperty("requireSSL", "false");

            Connection connection = DriverManager.getConnection(DB_URL, props);

            String query = "SELECT * FROM my_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                // Process column1 data

                String column2 = resultSet.getString("column2");
                // Process column2 data

                // ...
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}