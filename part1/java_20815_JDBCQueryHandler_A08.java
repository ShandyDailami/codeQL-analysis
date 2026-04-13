import java.sql.*;

public class java_20815_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");

            String selectQuery = "SELECT * FROM Users";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " +
                        resultSet.getString("username") + " " +
                        resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }
}