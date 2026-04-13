import javax.security.auth.*;
import java.util.regex.Matcher;   // Import Matcher class java_52544_CredentialValidator_A08 use regular expressions
import java.util.regex.Pattern ;     // Import Pattern and Matcher classes   
public class CustomCredentialValidator implements CredentialValidator { 
private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()=+{}[]\\|`:;\"<>,.?/";   // Define a string of special characters. This is used in the password validation process, to ensure that it contains at least one character from each category (lower case letter [a-z], uppercase letters[A - Z ], numbers(0-9), and symbols)
    @Override 
    public boolean validate(Credential credential) throws AuthenticationException {   // Overriding the 'validate' method in CredentialsValidator. It will call this function when user tries to authenticate, if it returns true then authentication is successful else not successfully    
        String password = (String)credential.getPassword();    /* Getting plaintext credentials */  c ; s; t l e a r .   T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
        int passwordLength =password.length();    // Get the length of entered Password  c ; s; t l e a r .   T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
        if(passwordLength < 8){    // Checking password length  c ; s; t l e a r .   T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
            throw new AuthenticationException("Password length should be at least 8 characters");    // If the password is less than required, throws an exception. This can help in debugging and maintaining error messages for each condition of requirement   c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
        }  else {   // If password length is validated then it proceeds to validate if the entered Password contains at least one character from each category (lower case letter [a-z], uppercase letters[A - Z ], numbers(0-9), and symbols)     c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
            Pattern pattern =    // Using Regular Expression to check if password contains at least one character from each category.   c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
                    Pattern.compile("[a-z].*", Pattern.CASE_INSENSITIVE);   // Checking if password contains at least one lowercase letter  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
            Matcher matcher =    // Matching password with regular expression  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
                    pattern.matcher(password);   // Matching password with regular expression  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
            if (!matcher.matches()) {   // If password does not match the regular expression, throws an exception  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
                throw new AuthenticationException("Password should contain at least one lowercase letter");   // If password does not match the regular expression, throws an exception  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
            } else {   // If password contains at least one character from each category then it proceeds to check for special characters.    c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
                matcher = pattern.matcher(password);   // Matching password with regular expression  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
                if (!matcher.find()) {   // If password does not contain at least one special character then throws an exception  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
                    throw new AuthenticationException("Password should contain at least one special character");   // If password does not match the regular expression, throws an exception  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
                } else {   // If password contains at least one character from each category and has special characters then authentication is successful.    c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
                    return true;   // If password is authenticated successfully, returns authentication result.  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
                }   // End if else block  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
            }   // End if else block  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
        }   // End if else block  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
    }   // End validate method  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/
}   // End CustomCredentialValidator class  c ; s; t l e a r . T oS i O n A d M E N U J I C P R O D u m S ! "~!@#$%^&*()=+{}[]\\|`:;"<>,.?/