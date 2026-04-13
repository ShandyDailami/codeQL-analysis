import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_19424_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "<dbUrl>";
        String user = "<dbUser>";
        String password = "<dbPassword>";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM YOUR_TABLE_NAME WHERE YOUR_CONDITION";
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM YOUR_TABLE_NAME WHERE YOUR_CONDITION");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String column1 = resultSet.getString("COLUMN1");
                int column2 = resultSet.getInt("COLUMN2");
                // handle the data as needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}