public class java_49509_CredentialValidator_A08 {
    public static void main(String[] args) throws Exception{
        String inputPassword = "123456"; // Hard-Coded Password. Replace with user entered password from the UI or some other source of data 
        
        if (isValidatedIntegrityFailureCredentials("", "", inputPassword)) {   
            System.out.println(inputPassword + " is valid!");  
             } else{    
                throw new Exception ("Invalid Password");      //If password entered does not match, throws an exception 
        }}`;