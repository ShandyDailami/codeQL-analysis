import java.sql.*;

public class java_37399_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_37399_JDBCQueryHandler_A03(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        JDBCQueryHandler queryHandler = new JDBCQueryHandler(url, user, password);

        ResultSet rs = queryHandler.executeQuery("SELECT * FROM Users");

        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("Name: " + name + ", Age: " + age);
        }

        queryHandler.closeConnection();
    }
}