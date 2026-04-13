public class java_37904_CredentialValidator_A03 implements CredentialValidator {

    private Set<String> validChars;

    public java_37904_CredentialValidator_A03() {
        validChars = new HashSet<>();
        validChars.add("a");
        validChars.add("b");
        validChars.add("c");
        validChars.add("d");
        validChars.add("e");
        validChars.add("f");
    }

    @Override
    public boolean validate(String username) {
        for (char c : username.toCharArray()) {
            if (!validChars.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }
}