import java.sql.*;

public class java_14958_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_14958_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void performQuery(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Here we assume the query returns only 1 field (e.g., the employee ID)
                int id = resultSet.getInt("id");
                System.out.println("Employee ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always close the statement and connection to prevent memory leaks
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
    }
}