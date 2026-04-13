import java.sql.*;

public class java_20339_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_20339_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        ResultSet result = handler.executeQuery("SELECT * FROM users");
        while (result.next()) {
            String name = result.getString("name");
            // do something with the name
        }
        handler.closeConnection();
    }
}