public class java_34291_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> users;

    public java_34291_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    @Override
    public boolean validate(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

}