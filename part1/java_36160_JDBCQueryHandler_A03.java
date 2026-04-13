import java.sql.*;

public class java_36160_JDBCQueryHandler_A03 {

    private Connection conn;
    private Statement stmt;

    public java_36160_JDBCQueryHandler_A03(String dbURL, String dbUser, String dbPassword) throws SQLException {
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void close() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost/test";
        String dbUser = "root";
        String dbPassword = "password";

        JDBCQueryHandler jdbcHandler;

        try {
            jdbcHandler = new JDBCQueryHandler(dbURL, dbUser, dbPassword);
            ResultSet rs = jdbcHandler.executeQuery("SELECT * FROM Users");

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            jdbcHandler.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}