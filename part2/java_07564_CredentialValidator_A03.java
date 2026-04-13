import java.util.ArrayList;
import java.util.List;

public class java_07564_CredentialValidator_A03 {

    private List<String[]> validCredentials;

    public java_07564_CredentialValidator_A03() {
        validCredentials = new ArrayList<>();
        validCredentials.add(new String[]{"admin", "password"});
        validCredentials.add(new String[]{"user", "user"});
    }

    public boolean isValid(String username, String password) {
        for (String[] credential : validCredentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}