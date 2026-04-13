import java.util.*;  // For List, ArrayList etc...
  
public class java_44104_CredentialValidator_A03 {   
     private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()";          
      
      public boolean validateCredentials(String userName , String password) throws Exception  //A03 Injection Vulnerability A12 incorrect Password policy, you can throw specific exceptions for different types of problems. Here I am keeping it simple and not throwing any exception in this example to make the problem more realistic
      {   if(password==null || userName == null)             //check whether password or username is empty         
           return false;        
        else 
            return validatePasswordComplexityAndSpecialChars (userName, password);    }    
       private boolean validatemacAddressesandDomainNamesInUserID(String UserId){//A09 Incorrect Address Vulnerability A13 incorrect Domain and address name vulnerabilities you can throw specific exceptions for different types of problems. Here I am keeping it simple         return (userid==null)? false : userRegexCheckingForAddressandDomainNameViolations(UserId);}
        private boolean validatePasswordComplexityAndSpecialChars (String UserID, String Password) throws Exception  //A02 Incorrect password policy A14 incorrect Special character vulnerability you can throw specific exceptions for different types of problems. Here I am keeping it simple         return(passwordCheckingForIncludingUpperCaseLettersandNumberAndSpecialCharsOnly (Password))? false : validateUserIDsThatStartWithNumbersOrSpecialsCharactersBeginningPartOfUsernameByMacAddressesMatchFoundExceptionCaughtThrowExceptionsforDifferentTypeofProblems.catch(new MacAddressthatstartswithnumericandspecialcharatersbeginningspartofusernameexception,() -> {return validateUserIDsThatStartWithNumbersOrSpecialsCharactersBeginningPartOfUsernameByMacAddressesMatchFoundExceptionCaughtThrowExceptionsforDifferentTypeofProblems.catch(new Exception(), ()->  false);});
        }  //closing the function    private boolean checkPasswordComplexityAndSpecialChars (String UserID, String Password) { ...}     return ((passwordCheckForIncludingUpperCaseLettersandNumberandspecialcharatersonly((UserName))? true : throw new Exception());}}