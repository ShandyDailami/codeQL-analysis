public class java_09599_CredentialValidator_A03 implements CredentialValidator {

    private static final String UPPERCASE_LETTER = "([A-Z])";
    private static final String LOWERCASE_LETTER = "([a-z])";
    private static final String DIGIT = "(\\d)";
    private static final String MIN_LENGTH = "(\\d{8,})";
    private static final String ALL_SPECIAL_CHARACTERS = "(?=.*[~<>@#$%^&*(){}|?/\\-+])";

    @Override
    public boolean validate(String username, String password, boolean userExists) throws SQLException {
        if (password.matches("^$") || password.length() < 8) {
            return false;
        }
        if (!password.matches(UPPERCASE_LETTER + LOWERCASE_LETTER + DIGIT + MIN_LENGTH + ALL_SPECIAL_CHARACTERS)) {
            return false;
        }
        return true;
    }

    @Override
    public List<String> getExplanation(String username, String password, boolean userExists) {
        List<String> explanationList = new ArrayList<>();
        if (!userExists && password.matches("^$") || password.length() < 8) {
            explanationList.add("Password should be at least 8 characters and contain at least one upper case letter, one lower case letter, one digit and one special character (~<>@#$%^&*(){}|?/\\-+). ");
        }
        return explanationList;
    }
}