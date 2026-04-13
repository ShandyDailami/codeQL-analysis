import java.util.Base64;

public class java_30453_CredentialValidator_A03 {
    private String[] validUsers = {"user1", "user2", "user3"};
    private String[] validPasswords = {"password1", "password2", "password3"};

    public boolean validate(String user, String password) {
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordString = new String(decodedPassword);
        
        for (int i = 0; i < validUsers.length; i++) {
            if (validUsers[i].equals(user) && validPasswords[i].equals(decodedPasswordString)) {
                return true;
            }
        }
        return false;
    }
}