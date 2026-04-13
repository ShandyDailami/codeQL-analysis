import java.util.*;   // For ArrayList and Scanner class java_44174_CredentialValidator_A07   
public Class CredentialValidator {    
      private List<String> validUsers = new ArrayList<>();      
            
         public void init() {         
                populateValidUserList ();        } 
                 
              protected boolean isValidCredentials(final String username, final char[] password) throws Exception   // assuming exception will be thrown if login fails due to incorrect credentials and it's not implemented.    
             {% set validPassword=... %}      {         return false;}         
               private void populateValidUserList()  {}       public boolean validate(String username,char []password){        for (final String user:validUsers)   //loop through the list of users and match passwords with entered credentials.     {% set validPassword=... %}      {         return false;}         
}