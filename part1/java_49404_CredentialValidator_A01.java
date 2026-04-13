public class java_49404_CredentialValidator_A01 {
    // Hardcoded credentials, this should not be done in real applications because of security reasons like SQL injection etc...
    private static final String USERNAME = "admin";  
    private static final String PASSWORD  ="password1234567890$%^&*()_+`~|}{[]:;?><,./-=";  //This is a hardcoded password. It should be kept secret and not in the codebase
    
    public static boolean validate(String inputUsername, String inputPassword){        
        return (USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword));//Checking if entered credentials match hardcoded ones 
	}  	      		          			                 }`                   //End of the code snippet                         `java'      /* This is a comment */