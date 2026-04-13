import javax.security.auth.Credential;  // Import Credentials object from Java Security API (JSA)  
     import java.util.*;                // For using ArrayList and Collections classes in this program   
     
public class java_47931_CredentialValidator_A08 {            // Declaring Class name as 'CustomValidator'      
                                        
                                        public boolean validate(Credential credential){  // Method to check if Credentials are valid or not         
                                              String password = new String (credential.getPassword());  
                                            
                                            List<String> weakPasswords=new ArrayList<>();        // Declaring and initializing a list of 'weak' Password strings              
                                               
                                        	     weakPasswords.add("123456");  /* Adding some example passwords to the WeakPasswordList */  
                                                 
                                            boolean isValid=false;                             // Default value for Validation set as false       
                                            
                                        if(password != null){                                  // Check that Password passed validation, If not return False   
                                               
                                        	     /* For checking a password against the list of weak words */  
                                                 	if (Arrays.asList(weakPasswords).contains(password)){ 
                                                                        isValid = false;                     } else {isValid=true;}      // Check if Password exists in WeakPassword List, If found set 'isvalid' as False         
                                            return isValid ;                                                          /* Return Result */     }}                 };