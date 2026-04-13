import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

public class java_21526_CredentialValidator_A08 {

    // This is a simplistic example, in real application you should use a more secure storage method
    private static final String[] USERS = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"password1", "password2", "password3"};

    public static boolean validateCredentials(HttpServletRequest request, HttpServletResponse response) {
        String userCredentials = request.getHeader("Authorization");
        if (userCredentials == null) {
            return false;
        }

        String encodedCredentials = userCredentials.replace("Basic ", "");
        byte[] decodedBytes = Base64.decodeBase64(encodedCredentials);
        String credentials = new String(decodedBytes, "UTF-8");
        String[] splitCredentials = credentials.split(":");

        String providedUser = splitCredentials[0];
        String providedPassword = splitCredentials[1];

        for (int i = 0; i < USERS.length; i++) {
            if (USERS[i].equals(providedUser) && PASSWORDS[i].equals(providedPassword)) {
                return true;
            }
        }

        return false;
    }
}