import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_24317_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users WHERE role='ADMIN'");

            List<String> adminNames = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                adminNames.add(name);
            }

            for (String name : adminNames) {
                System.out.println("Admin: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}