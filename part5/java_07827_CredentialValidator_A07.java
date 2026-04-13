import java.util.Base64;

public class java_07827_CredentialValidator_A07 {
    public static class Credentials {
        private String username;
        private String password;

        public java_07827_CredentialValidator_A07(String username, String password) {
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

    public static class UserDatabase {
        private static final Credentials[] users = {
            new Credentials("user1", "password1"),
            new Credentials("user2", "password2"),
            new Credentials("user3", "password3")
        };

        public static Credentials getUserByUsername(String username) {
            for (Credentials user : users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        }
    }

    public static class AuthFailureException extends Exception {
        public java_07827_CredentialValidator_A07(String message) {
            super(message);
        }
    }

    public static boolean validateCredentials(String username, String password) throws AuthFailureException {
        Credentials user = UserDatabase.getUserByUsername(username);

        if (user == null) {
            throw new AuthFailureException("Invalid username");
        }

        if (!user.getPassword().equals(decryptPassword(password))) {
            throw new AuthFailureException("Invalid password");
        }

        return true;
    }

    private static String decryptPassword(String password) {
        byte[] encodedBytes = Base64.getDecoder().decode(password);
        return new String(encodedBytes);
    }
}