import com.sun.security.validator.*;

public class java_39583_CredentialValidator_A07 {
    public static class MyValidator implements CredentialValidationResult {
        private String username;
        private String password;
        private String caller;

        public java_39583_CredentialValidator_A07(String username, String password, String caller) {
            this.username = username;
            this.password = password;
            this.caller = caller;
        }

        public String getUsername() {
            return this.username;
        }

        public String getPassword() {
            return this.password;
        }

        public String getCaller() {
            return this.caller;
        }

        public boolean validate(ValidationCallback callback) {
            if (username == null || password == null) {
                callback.selected(false);
                return false;
            } else if (username.length() < 6) {
                callback.outOfSpace(username);
                return false;
            } else if (password.length() < 6) {
                callback.outOfSpace(password);
                return false;
            } else {
                callback.selected(true);
                return true;
            }
        }
    }

    public static void main(String[] args) {
        CredentialValidationResult result = new MyValidator("test", "password", "main");
        result.validate(new ValidationCallback() {
            public void selected(boolean selected) {
                System.out.println("User selected: " + selected);
            }

            public void outOfSpace(String s) {
                System.out.println("Out of space: " + s);
            }
        });
    }
}