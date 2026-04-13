import java.sql.*;

public class java_20545_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String selectQuery = "SELECT * FROM Users WHERE id >= 100 AND id <= 200";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("ID: " + id + ", Name: " + name);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}