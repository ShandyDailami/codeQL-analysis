import java.sql.*;

public class java_01492_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            String query = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 1); // Assuming the user's id is 1

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                // Perform additional secure operations with the user's data
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}