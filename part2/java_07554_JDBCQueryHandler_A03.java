import java.sql.*;

public class java_07554_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_07554_JDBCQueryHandler_A03(String url, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(sql);
        return statement.executeQuery();
    }

    public void executeUpdate(String sql) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password")
                    .executeUpdate("CREATE TABLE users (id INT, name VARCHAR(255))");

            ResultSet rs = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password")
                    .executeQuery("SELECT * FROM users");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password").closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}