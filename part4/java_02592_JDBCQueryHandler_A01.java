import java.sql.*;

public class java_02592_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    private Connection connection;

    public java_02592_JDBCQueryHandler_A01() {
        connect();
    }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }

    public void runQuery(String query) {
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("column_name"));
                }
                statement.close();
            } catch (SQLException e) {
                System.out.println("Failed to run query: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler().runQuery("SELECT * FROM table_name");
    }
}