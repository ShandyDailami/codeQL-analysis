import java.sql.*;

public class java_16224_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_16224_JDBCQueryHandler_A07(String url, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        // Replace the placeholders with your actual values
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "username";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, user, password);

            ResultSet result = handler.executeQuery("SELECT * FROM users");
            while (result.next()) {
                String name = result.getString("name");
                int age = result.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}