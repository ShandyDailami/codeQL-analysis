import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_02430_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_02430_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        this.credentials.put("user1", Base64.getEncoder().encodeToString("user1:user1".getBytes()));
    }

    @Override
    public boolean validate(String username, String password) {
        String expectedPassword = credentials.get(username);
        if (expectedPassword == null) {
            return false;
        }

        byte[] expectedBytes = Base64.getDecoder().decode(expectedPassword);
        byte[] suppliedBytes = Base64.getDecoder().decode(password);

        return Arrays.equals(expectedBytes, suppliedBytes);
    }
}