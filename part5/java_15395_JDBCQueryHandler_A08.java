import java.sql.*;

public class java_15395_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    private Connection connection;

    public java_15395_JDBCQueryHandler_A08() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void performQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Do something with the result set.
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Query failed!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.performQuery("SELECT * FROM my_table");
    }
}