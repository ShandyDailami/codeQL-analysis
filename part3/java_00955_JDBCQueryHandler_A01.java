import java.sql.*;

public class java_00955_JDBCQueryHandler_A01 {

    public static Connection connectToDatabase(String dbURL, String username, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected successfully to database!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        Connection conn = connectToDatabase(dbURL, username, password);

        if (conn != null) {
            String query = "SELECT * FROM employees";
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }

            } catch (SQLException e) {
                System.out.println("Error while executing query: " + e.getMessage());
            } finally {
                try {
                    if (stmt != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error while closing statement: " + e.getMessage());
                }
            }
        }
    }
}