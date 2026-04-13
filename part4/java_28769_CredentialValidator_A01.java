import java.util.Arrays;
import java.util.List;

public class java_28769_CredentialValidator_A01 implements java.security.auth.PasswordValidator {

    private static final String[] BAD_PASSWORDS = {"password", "abc", "123456"};

    @Override
    public List<String> validate(String arg0) {
        for(String badWord : BAD_PASSWORDS) {
            if(arg0.toLowerCase().contains(badWord)) {
                return Arrays.asList("Bad Password");
            }
        }
        return Arrays.asList("Password OK");
    }

}