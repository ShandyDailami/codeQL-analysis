// CredentialValidator example program using standard libraries

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_24347_CredentialValidator_A03 {
    // A method to validate password
    public static boolean validatePassword(String password) {
        // Check for null password
        if (password == null) {
            return false;
        }

        // Check for length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letter
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find() == false) {
            return false;
        }

        // Check for lowercase letter
        pattern = Pattern.compile("[a-z]");
        matcher = pattern.matcher(password);
        if (matcher.find() == false) {
            return false;
        }

        // Check for digit
        pattern = Pattern.compile("[0-9]");
        matcher = pattern.matcher(password);
        if (matcher.find() == false) {
            return false;
        }

        // Check for special character
        pattern = Pattern.compile("[^a-zA-Z0-9]");
        matcher = pattern.matcher(password);
        if (matcher.find() == false) {
            return false;
        }

        return true;
    }

    // A method to validate username
    public static boolean validateUsername(String username) {
        // Check for null username
        if (username == null) {
            return false;
        }

        // Check for length
        if (username.length() < 4) {
            return false;
        }

        // Check for alphabets only
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(username);
        if (matcher.find() == false) {
            return false;
        }

        return true;
    }

    // A method to validate email
    public static boolean validateEmail(String email) {
        // Check for null email
        if (email == null) {
            return false;
        }

        // Check for valid email format
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find() == false) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test credentials
        String password = "Password@123";
        String username = "john_doe";
        String email = "john_doe@gmail.com";

        if (validatePassword(password)) {
            System.out.println("Validated password");
        } else {
            System.out.println("Invalidated password");
        }

        if (validateUsername(username)) {
            System.out.println("Validated username");
        } else {
            System.out.println("Invalidated username");
        }

        if (validateEmail(email)) {
            System.out.println("Validated email");
        } else {
            System.out.println("Invalidated email");
        }
    }
}