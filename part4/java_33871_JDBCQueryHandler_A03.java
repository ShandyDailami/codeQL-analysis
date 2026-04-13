import java.sql.*;

public class java_33871_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare Statements
            String selectQuery = "SELECT * FROM Employee";
            String insertQuery = "INSERT INTO Employee (id, name, salary) VALUES (1, 'John', 5000)";
            String updateQuery = "UPDATE Employee SET name='Mike' WHERE id=1";
            String deleteQuery = "DELETE FROM Employee WHERE id=1";

            PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
            PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);

            // Step 3: Execute Statements
            ResultSet rs = selectStmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("salary"));
            }

            insertStmt.executeUpdate();

            updateStmt.executeUpdate();

            deleteStmt.executeUpdate();

            // Step 4: Close Connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}