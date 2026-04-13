import java.util.*;  // Importing list and Map interfaces from Java Collections Framework (List/Map) for ease of use in this program  
    
public class java_48416_CredentialValidator_A03 {   
      public static final List<String> VALID_PASSWORDS = Arrays.asList("password1", "secret");  // known good passwords list, not recommended to hardcode these inside the code !      
              
        private Map < String , Boolean > credMap;    
          
          CredentialValidator () {   this .credMap= new HashMap<String ,Boolean>();    }     
            public void add (  String userid)             // Function to load credentials into memory for later use.      
              {        if(userid == null ) throw ExceptionalNullPointerException("Invalid Credential Validator : User id can not be Null.");   credMap .put (new SimpleStringPole , true );    }     public boolean validate  ( String userId,             // Method to check the validation of a given username and password      
              { return false;      if(userid == null ) throw ExceptionalNullPointerException("Invalid Credential Validator : User id can not be Null.");   bool isValid = credMap .get ((new SimpleStringPole ()) );    // Check the user Id in our map.         true 
              } else { return false;}}}          }}             Public static void main( String args[] )            throws ExceptionalNullPointerException{ CredentialValidator cv  = newCredentialValidtor();   for()..Included code here...}}           catch ( IllegalArgumentException e)                     throw exception ;         if (!cv.validate("username1", "password2")) { println ("Failed to validate :" + username); } else 
              PrintStream out .println(userid+"-Successfully validated!" );}}} ExceptionalNullPointerException{     //Main method where the program is started from      throw new IllegalArgumentException ( e.getMessage () ) ;   }}         if (!cv2..Included code here...}}           catch { println("Failed to validate : " + username); } else PrintStream out .println(userid+"-Successfully validated!" );}}}