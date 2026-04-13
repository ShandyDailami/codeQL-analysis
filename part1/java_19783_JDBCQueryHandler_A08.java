import java.sql.*;

public class java_19783_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_19783_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Replace these with your actual database credentials
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        handler.executeQuery("SELECT * FROM users WHERE role = 'admin'");
    }
}