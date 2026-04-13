import java.sql.*;

public class java_25139_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_25139_JDBCQueryHandler_A07(String dbURL, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // handle exception
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("username") + " " + rs.getString("password"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // handle exception
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // handle exception
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
        handler.executeQuery("SELECT username, password FROM users");
        handler.closeConnection();
    }
}