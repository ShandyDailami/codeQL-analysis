import java.sql.*;

public class java_38391_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_38391_JDBCQueryHandler_A08() {
        try {
            // Load the drivers
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the connection
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void performQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new VanillaJavaJDBCQueryHandler().performQuery("SELECT username FROM users WHERE username = 'test'");
    }
}