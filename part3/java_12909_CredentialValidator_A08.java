import java.util.Base64;
import java.util.zip.CRC32;
import java.nio.ByteBuffer;

public class java_12909_CredentialValidator_A08 {

    public static class Credentials {
        private String username;
        private String password;

        public java_12909_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class PasswordStrength {
        private boolean isStrong;
        private int strength;

        public java_12909_CredentialValidator_A08(boolean isStrong, int strength) {
            this.isStrong = isStrong;
            this.strength = strength;
        }

        public boolean isStrong() {
            return isStrong;
        }

        public int getStrength() {
            return strength;
        }
    }

    public static PasswordStrength validate(Credentials credentials) {
        String password = credentials.getPassword();
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Check if password is strong enough.
        // This is a very basic check and can be improved.
        int minStrength = 1;
        int maxStrength = 10;
        if (encodedPassword.length() < minStrength * 2) {
            return new PasswordStrength(false, minStrength);
        } else if (encodedPassword.length() > maxStrength * 2) {
            return new PasswordStrength(false, maxStrength);
        }

        // Check if password contains a certain sequence.
        // This is a very basic check and can be improved.
        if (encodedPassword.contains("password") || encodedPassword.contains("123456")) {
            return new PasswordStrength(false, 2);
        }

        // Check if password is a repeating pattern.
        // This is a very basic check and can be improved.
        String[] patterns = {"abc", "123", "password"};
        for (String pattern : patterns) {
            if (encodedPassword.contains(pattern)) {
                return new PasswordStrength(false, 1);
            }
        }

        return new PasswordStrength(true, 3);
    }

    public static void main(String[] args) {
        Credentials credentials = new Credentials("user", "password123");
        PasswordStrength strength = validate(credentials);

        System.out.println("Strength: " + strength.getStrength());
        System.out.println("Is Strong: " + strength.isStrong());
    }
}