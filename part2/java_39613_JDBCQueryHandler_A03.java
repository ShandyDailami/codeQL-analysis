import java.sql.*;

public class java_39613_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_39613_JDBCQueryHandler_A03(String url, String username, String password) {
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
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
           
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password")
                .executeQuery("SELECT id, name FROM employees");
    }
}