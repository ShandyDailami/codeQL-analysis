import java.util.function.BiPredicate;

public class java_05563_CredentialValidator_A08 implements java.util.function.Function<String, Boolean> {

    private final BiPredicate<String, String> credentialChecker;

    public java_05563_CredentialValidator_A08(String correctUsername, String correctPassword) {
        credentialChecker = (username, password) -> username.equals(correctUsername) && password.equals(correctPassword);
    }

    @Override
    public Boolean apply(String username) {
        return credentialChecker.test(username, "password");
    }
}