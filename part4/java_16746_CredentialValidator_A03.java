import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class java_16746_CredentialValidator_A03 {
    private HashMap<String, String> userMap;

    public java_16746_CredentialValidator_A03() {
        userMap = new HashMap<>();
        userMap.put("user1", getMD5("password1")); // MD5 is used here for simplicity
        userMap.put("user2", getMD5("password2"));
        // Add more users as per your requirements
    }

    public boolean validate(String username, String password) {
        String hashedPassword = getMD5(password);
        return hashedPassword.equals(userMap.get(username));
    }

    private String getMD5(String password) {
        String md5Password = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            md5Password = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Password;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate user1
        boolean user1Valid = validator.validate("user1", "password1");
        System.out.println("User1 valid: " + user1Valid);

        // Validate user2
        boolean user2Valid = validator.validate("user2", "password2");
        System.out.println("User2 valid: " + user2Valid);
    }
}