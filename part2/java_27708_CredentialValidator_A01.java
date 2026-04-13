public class java_27708_CredentialValidator_A01 {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+={}[]|\\:;<>,.?/~`";
    private static final String SPECIAL_CHARACTERS_REGEX = "[`~^@\\[\\]|{}<>\\\\(\\)?*+\\-=\\;',\\\"\\.\\<\\>\\/\\\\\\]";
    private static final String NUMBER_REGEX = "\\d";
    private static final String UPPERCASE_REGEX = "\\p{Lu}";
    private static final String LOWERCASE_REGEX = "\\p{Ll}";

    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (password.matches(SPECIAL_CHARACTERS_REGEX)) {
            return false;
        }

        if (!password.matches(NUMBER_REGEX) && !password.matches(UPPERCASE_REGEX) && !password.matches(LOWERCASE_REGEX)) {
            return false;
        }

        return true;
    }
}