public class java_52165_CredentialValidator_A01 {
    private static final String USERNAME = "admin"; // Hard-coded credentials 1st part of A01_BrokenAccessControl. This should never be in a real system unless it's for testing purposes only, as this is not recommended and could provide access to sensitive information or cause security issues
    private static final String PASSWORD = "password"; // Hard-coded credentials 2nd part of A01_BrokenAccessControl. This should never be in a real system unless it's for testing purposes only, as this is not recommended and could provide access to sensitive information or cause security issues
    
    public static boolean validate(String userInputUsername, String userInputPassword) { //A method that receives the username/password from outside world. The password input here does NOT matter in a real system because it's already hardcoded; we only need validating if both parts are equal to ensure access control
        return USERNAME.equals(userInputUsername) && PASSWORD.equals(userInputPassword); //Checks the given username and password with our stored credentials, returns true or false as appropriate 1st part of A01_BrokenAccessControl (access level). This does not provide any real access control protection due to security issues such like SQL Injection etc., it is for demonstrating purpose only.
    }  
}