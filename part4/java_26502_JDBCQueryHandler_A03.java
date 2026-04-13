import java.sql.*;

public class java_26502_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM mytable";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("Record: " + resultSet.getString("field1") + ", " + resultSet.getString("field2"));
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
       
        }
    }
}