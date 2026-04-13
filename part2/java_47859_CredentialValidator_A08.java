import java.security.*;   // Importing Java Security Package for hashing passwords, including MessageDigest and SecureRandom classes from javax library    
    import java.util.*;   //Importing Collection Framework (ArrayList) to use in the program     
      
public class java_47859_CredentialValidator_A08 { 
        private ArrayList<String> validPasswords;//Declare a list of passwords which will be used for validation purpose          
         public boolean validatePassword(final String userName, final String inputPwd){            //Defining method to check if the entered pw matches stored one.   
                MessageDigest md = null ;            
               try {             
                    /* Create a message digest with SHA1 algorithm */                     
                        md  = MessageDigest.getInstance("SHA1");      
                            }  catch (NoSuchAlgorithmException e) {         //Catch if instance not found           
                                System.out.println( "Invalid Algorithm" );     return false;         
                               };      try{   /* Get the hash value of password */             md.update(inputPwd . getBytes());       }        catch (Exception e){  printStackTrace();return False;}           //Update message digest with given input            if (!checkExistingPasswordHasher_SHA1DigestToHexStr((md).digest(),userName)) {         return false;         
               try{             /* Get the hash value of password */              md.update(inputPwd . getBytes());}      catch (Exception e){ printStackTrace();return False;}           //Update message digest with given input            if (!checkExistingPasswordHasher_SHA1DigestToHexStr((md).digest(),userName)) {         return false;         
        } 
    /*The function below is to compare hash of entered password and stored in database*/       private boolean checkExistingPasswordHasher_SHA1DigestToHexStr(byte[] digest,String user){     //Declare a method for hashing the given input with SHA-1 algorithm.       
         if (digest == null || user==null) { return false; }           try{      /*Getting hex value of entered password*/          String existingPassword = getExistingHash(user);       md .update((existingPassword).getBytes());}catch (Exception e){ printStackTrace();return False;}     //Update message digest with given input       
         byte[] detectedDigest = md.digest() ;           return convertByteArrayToHexString_SHA1(detectedDigest) .equalsIgnoreCase  (existingPassword);   }      /*Function to compare hash*/    private String getExistingHash(final User user){     //Declare method that will retrieve the stored password from database by username.      
         return "";//you should replace this line with your actual implementation of retrieval          }                  try {           validPasswords = new ArrayList<String>();  /* Initializing list */      loadValidPassword("valid_pass");        for (Iterator iterator= passList .iterator() ;iterable.hasNext())         String password  =  
(String) Iterators..nextElement());                //Loading Password List into validPasswords           } catch Exception e { printStackTrace();}            */    private void loadValidPassword(final Collection collection){     /* Declare method to Loading Valid PWs from DB or file.*/  try{
             for (Iterator iterator= passList .iterator() ;iterable.hasNext())         String password  =   Iterators..nextElement();        PasswordValidator pv = newPasswordValidator(password); if (!pv isValid) { printStackTraceAndExit("Invalid Credentials") } else{validPasswords
list of validPWs (passList).add(encryptingTheUserNameandEncryptedValue_withSalt());      //Add password to the list}    catch Exception e {printstacktrace();return;}        private void printStackTraceAndExit(String message){     /* Declare method for logging exceptions and exit*/  Log.e("Exception",message); System .exit (0 ); }