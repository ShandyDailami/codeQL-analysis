import java.sql.*;

public class java_19537_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your-database-url";
    private static final String USER = "your-username";
    private static final String PASSWORD = "your-password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String selectQuery = "SELECT * FROM USERS WHERE ID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, 1); // replace 1 with the actual user id

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("User found");
            } else {
                System.out.println("User not found");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}