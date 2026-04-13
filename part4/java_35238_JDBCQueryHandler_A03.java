import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35238_JDBCQueryHandler_A03 {

    private Connection conn;

    public void connectToDB(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String query) throws SQLException {
        if(conn != null) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Print the result set
            while(rs.next()) {
                System.out.println(rs.getString("field_name"));
            }
            rs.close();
            stmt.close();
        } else {
            throw new SQLException("Connection is null");
        }
    }

    public void closeConnection() throws SQLException {
        if(conn != null) {
            conn.close();
        } else {
            throw new SQLException("Connection is null");
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbc = new JDBCQueryHandler();
        try {
            jdbc.connectToDB("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            jdbc.executeQuery("SELECT * FROM my_table");
            jdbc.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}