// Start of '``java' section (Note that it is considered bad practice) 
public class java_49035_CredentialValidator_A01 {     // start with public so we can call this from outside our package.  
    private static final String EXPECTED_PASSWORD = "password";      // define a constant for the expected password, never change or reuse them across your codebase! (Again A01) 
      
public boolean validate(String enteredPassword){     // create public method to check if passed in string matches our 'expected' one.  
    return EXPECTED_PASSWORD .equalsIgnoreCase(enteredPassword);      /* use the equals() and ignore case methods provided by java String class for checking,  (A02) */        }       end of validate function}     // close curly bracket ('