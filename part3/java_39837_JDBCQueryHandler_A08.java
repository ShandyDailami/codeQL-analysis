import java.sql.*;

public class java_39837_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_39837_JDBCQueryHandler_A08(String url, String username, String password) {
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
                System.out.println(resultSet.getString("columnName"));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
       
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/database", "username", "password");
        handler.executeQuery("SELECT * FROM tableName");
    }
}