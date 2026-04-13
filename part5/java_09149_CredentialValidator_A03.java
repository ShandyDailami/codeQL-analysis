import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class java_09149_CredentialValidator_A03 {

    private String username;
    private String password;

    public java_09149_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid(HttpServletRequest request, HttpServletResponse response) {
        // Simplified example: checks if username and password match with hardcoded values
        return (username.equals("admin") && password.equals("password"));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // This could be in a Servlet, or a separate class
        // For example, you might have a form where the user can enter their username and password
        // Then you could call isValid in your Servlet or class
        HttpServletRequest request = // get request from somewhere
        HttpServletResponse response = // get response from somewhere

        if (validator.isValid(request, response)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}