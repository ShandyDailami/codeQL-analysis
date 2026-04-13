import java.sql.*;

public class java_08895_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Assume that the table "A07_AuthFailure" exists in the database with the following fields: id, username, password
            String query = "SELECT * FROM A07_AuthFailure";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                System.out.println("ID: " + id + ", User: " + user + ", Pass: " + pass);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}