import java.sql.*;

public class java_14732_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            String sql = "INSERT INTO employees (id, name, salary) VALUES (1, 'John', 3000)";
            statement.executeUpdate(sql);
            System.out.println("Record inserted successfully");
        } catch (SQLException e) {
            System.out.println("Error in connection");
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}