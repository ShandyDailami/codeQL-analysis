import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_21981_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourDatabase";
        String username = "yourUsername";
        String password = "yourPassword";

        try {
            // 1. Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // 3. Prepare a SQL statement
            String sql = "SELECT * FROM yourTable";
            PreparedStatement statement = connection.prepareStatement(sql);

            // 4. Execute the SQL statement
            ResultSet resultSet = statement.executeQuery();

            // 5. Process the ResultSet
            while (resultSet.next()) {
                System.out.println(resultSet.getString("yourColumn"));
            }

            // 6. Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}