import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;

public class java_41430_CredentialValidator_A03 implements CredentialValidator {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        validator.validate(new LegacyCredentials("user", "pass"));
    }

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        String decodedCredentials = new String(Base64.getDecoder().decode(credential.getCaller()));
        String[] credentials = decodedCredentials.split(":");
        String username = credentials[0];
        String password = credentials[1];

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT 1 FROM users WHERE username = ? AND password = ?")) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new InvalidCredentialException("SQL Exception", e);
        }

        throw new InvalidCredentialException("Invalid credentials");
    }

    static class LegacyCredentials {
        private String caller;

        public java_41430_CredentialValidator_A03(String caller) {
            this.caller = caller;
        }

        public String getCaller() {
            return caller;
        }
    }
}