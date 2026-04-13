import java.sql.*;

public class java_40808_SessionManager_A03 {
    private Connection connection;
    private Statement statement;

    public java_40808_SessionManager_A03() {
        initialize();
    }

    private void initialize() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
       
        }
    }
}