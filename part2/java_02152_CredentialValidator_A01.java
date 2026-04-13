public class java_02152_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_02152_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // This is a placeholder. In a real-world scenario,
        // you'd want to replace this with a more secure way
        // of comparing passwords, using a hashing algorithm
        // or other security measures.
        return this.username.equals("admin") && this.password.equals("password");
    }

}