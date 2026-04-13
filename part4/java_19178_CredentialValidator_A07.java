import java.util.function.Function;

public interface CredentialAccessor {
    Function<String, String> getPasswordFor(String username);
}

public class java_19178_CredentialValidator_A07 {
    private final CredentialAccessor accessor;

    public java_19178_CredentialValidator_A07(CredentialAccessor accessor) {
        this.accessor = accessor;
    }

    public boolean validate(String username, String password) {
        String correctPassword = accessor.getPasswordFor(username);
        return password.equals(correctPassword);
    }
}