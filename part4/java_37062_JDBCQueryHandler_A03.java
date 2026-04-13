import java.sql.*;

public class java_37062_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/dbname";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Record " + resultSet.getString("columnName"));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}