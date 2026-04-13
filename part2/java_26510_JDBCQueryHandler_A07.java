import java.sql.*;

public class java_26510_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_26510_JDBCQueryHandler_A07() {
        try {
            // Assume that we have already obtained the connection from a pool
            this.connection = DriverManager.getConnection("jdbc:your_database", "username", "password");
        } catch (SQLException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Process the result set
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
    }
}