import java.sql.*;

public class java_06662_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM Users WHERE username = '" + args[0] + "'";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String passwordFromDB = resultSet.getString("password");
                System.out.println("Password from database: " + passwordFromDB);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}