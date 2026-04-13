import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_03489_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "user1";
    private static final String PASSWORD = "password";

    private Map<String, String> credentials = new HashMap<>();

    public java_03489_CredentialValidator_A07() {
        // Set default credentials
        credentials.put("user1", Base64.getEncoder().encodeToString("user1:password".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("user2:password".getBytes()));
        credentials.put("user3", Base64.getEncoder().encodeToString("user3:password".getBytes()));
    }

    @Override
    public CredentialValidationResult validate(CredentialValidationContext context) {
        String userName = context.getCallerPrincipal().getName();
        String password = new String(context.getCallerPrincipal().getPassword());

        if (!credentials.containsKey(userName) || !credentials.get(userName).equals(Base64.getEncoder().encodeToString((userName + ":" + password).getBytes()))) {
            return CredentialValidationResult.failure();
        }

        return CredentialValidationResult.success();
    }
}