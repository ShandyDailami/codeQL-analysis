import java.sql.*;

public class java_12669_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection connection;

    public static void main(String[] args) {
        connectToDB();
        if (connection != null) {
            runQueries();
        } else {
            System.out.println("Failed to connect to the database");
        }
        closeConnection();
    }

    private static void connectToDB() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void runQueries() {
        String query1 = "SELECT * FROM Employees WHERE Age > 25";
        String query2 = "UPDATE Employees SET Age = 25 WHERE Name = 'John'";
        String query3 = "DELETE FROM Employees WHERE Age < 20";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Name"));
            }

            statement.executeUpdate(query2);

            ResultSet resultSet2 = statement.executeQuery(query1);
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("Name"));
            }

            statement.executeUpdate(query3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}