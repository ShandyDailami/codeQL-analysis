import java.util.Base64;

public class java_21750_CredentialValidator_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String enteredUsername = "admin";
        String enteredPassword = "password";

        if (isValid(enteredUsername, enteredPassword)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }

    public static boolean isValid(String username, String password) {
        byte[] decodedBytes = Base64.getDecoder().decode("YWRtaW46MTIzNDU2Nzg5MHx8fCBVcGlja2V0T2RqZWNraW5nIHZlcnkgYmFzZTY0LjQuMpD/AQ==");
        String decodedString = new String(decodedBytes);

        return decodedString.equals(USERNAME) && decodedString.equals(PASSWORD);
    }
}