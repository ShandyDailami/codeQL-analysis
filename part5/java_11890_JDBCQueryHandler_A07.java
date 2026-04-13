import java.sql.*;

public class java_11890_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 3: Prepare Statement
            Statement statement = connection.createStatement();

            // Step 4: Execute Query
            String sql = "SELECT * FROM Users WHERE username = 'test' AND password = 'test'";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Handle Result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Close Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}