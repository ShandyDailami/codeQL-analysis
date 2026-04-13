import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class java_34135_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public List<String> getAuthFailureDetails() {
        List<String> authFailureDetails = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM A07_AuthFailure")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                authFailureDetails.add("AuthFailure ID: " + resultSet.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authFailureDetails;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        List<String> authFailureDetails = handler.getAuthFailureDetails();

        for (String detail : authFailureDetails) {
            System.out.println(detail);
        }
    }
}