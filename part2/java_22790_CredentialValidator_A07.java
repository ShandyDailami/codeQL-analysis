import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class java_22790_CredentialValidator_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        if (Objects.isNull(username) || Objects.isNull(password)) {
            return false;
        }

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("PASSWORD");
                return Objects.equals(dbPassword, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (!Objects.isNull(resultSet)) {
                    resultSet.close();
                }
                if (!Objects.isNull(statement)) {
                    statement.close();
                }
                if (!Objects.isNull(connection)) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}