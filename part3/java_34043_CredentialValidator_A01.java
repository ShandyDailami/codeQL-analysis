public class java_34043_CredentialValidator_A01 implements CredentialValidator {

    private static final String SALT = "salt"; // this should be stored securely

    @Override
    public boolean validate(String username, String password) {
        // Since we're using a simple password, we'll just check if the password equals the username
        // This is a simple demonstration of a password validator. In a real world scenario, you'd want to hash the password and store the hashed value
        return password.equals(username);
    }

    @Override
    public boolean needDisplay() {
        return false;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountCredentialsNonExpired() {
        return true;
    }
}