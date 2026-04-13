import java.sql.*;

public class java_26617_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    public java_26617_JDBCQueryHandler_A07() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");
            this.stmt = this.conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            this.stmt.close();
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        ResultSet resultSet = handler.executeQuery("SELECT * FROM Users WHERE username = '" + "username" + "' AND password = '" + "password" + "'");

        try {
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        handler.closeConnection();
    }
}