import java.sql.*;

public class java_01715_JDBCQueryHandler_A01 {

    private Connection conn;

    public java_01715_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
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

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(url, username, password);

            String query = "SELECT * FROM my_table";
            ResultSet resultSet = jdbcQueryHandler.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            jdbcQueryHandler.closeConnection();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}