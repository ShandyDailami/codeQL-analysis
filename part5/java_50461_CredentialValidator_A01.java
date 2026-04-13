public class java_50461_CredentialValidator_A01 {  
    public boolean validate(String username) throws Exception{        //e is raised when userName or password doesn't matches the pattern         
            if(!username.matches("^[a-zA-Z].*"))                     //only first character can be special (no numbers, no other characters except alphabet), rest all are allowed    
                throw new UnauthorizedException();                    //throw exception when userName or password doesn't matches the pattern         
            return true;                                              //return success if username matched        
        }      
}