import java.sql.*;

public class java_35121_CredentialValidator_A07 implements CredentialValidator {

    private Connection conn = null;

    public java_35121_CredentialValidator_A07() {
        try {
            conn = DriverManager.getConnection("DB_URL", "USER", "PASSWORD");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validate(String username, String password) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("PASSWORD");
                return password.equals(dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}