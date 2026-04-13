import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_15919_CredentialValidator_A03 {

    private static final Pattern VALID_PASSWORD_PATTERN;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$");
        VALID_PASSWORD_PATTERN = Pattern.compile(sb.toString());
    }

    private int age;
    private String password;

    public java_15919_CredentialValidator_A03(int age, String password) {
        this.age = age;
        this.password = password;
    }

    public boolean isValid() {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(this.password);
        if (!matcher.matches()) {
            System.out.println("Invalid password: " + this.password);
            return false;
        }

        if (this.age < 18) {
            System.out.println("You must be at least 18 years old to use this service.");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator(20, "ThisIsAValidPassword12345678");
        System.out.println(validator.isValid());
    }
}