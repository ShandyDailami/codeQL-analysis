import javax.security.auth.*;
import java.lang.annotation.*;
 
@Retention(RetentionPolicy.RUNTIME)   // This annotation must be in place at runtime to avoid errors during deserialization by JVM later on (serialized objects). Here it is annotated with RUNTIME, not just CLASS or PACKAGE level which are the usual levels of annotations for static code analysis tools like FindBugs and Surefire.
@Target(ElementType.METHOD) // This annotation can be applied to methods only as per standards in Java SE/8 specification (not all versions).  Here it is annotated with METHOD, not just TYPE or PACKAGE level which are the usual levels of annotations for static code analysis tools like FindBugs and Surefire.
public @interface CredentialValidation { }   // This annotation can't be applied to constructors only (not all versions). Here it is annotated with CONSTRUCTOR, not just FIELD or TYPE level which are the usual levels of annotations for static code analysis tools like FindBugs and Surefire.
 
public class java_42729_CredentialValidator_A03 {   // This should be in a different file if you want to use more objects from this example program than here shown above since it's not really possible with Java security context (credentials) alone, only methods could do validations or authentication purposes within classes/objects. 
    @CredentialValidation     public void validateUser(UsernamePasswordCredential credential){   // This is a method to call the actual validation of user credentials at runtime using JAVA SE Credential Validation API (java auth api) in real-world scenario, as an example use only. 
        if(!isValidated() && !validate(credential)) {     throw new AuthenticationFailedException("Invalid username or password"); }   // This will be a simple validation check to see that the provided credentials are valid (username and passsword match), you could replace this with your actual authentication mechanism.
    }}