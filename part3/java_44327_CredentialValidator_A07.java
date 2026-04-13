class java_44327_CredentialValidator_A07 {  
    public static void main(String[] args) throws Exception{       
            // Check if the username and password are in memory for testing purposes        
           String storedUsername = "user";     
           String storedPassword ="pass1234567890!"; 
       System.out.println("Enter Username");   
          Scanner scanUser=new Scanner(System.in);   // Reading user input       
             String enteredUsername  =scanUser .next();     // User's username     
           System.out.println("\n Enter Password: ");      
            int length =256;                  char[] passwordChars =  new char[length];          Scanner scanPass=new Scanner(System.in);    String enteredPassword  =scanPass .next();   // User's  storedpassword     for (int i= 0 ;i<enteredPassword..length) {     
             if (!checkUserCredentialsValidity(storedUsername, savedEncryptedDecryptSHA256BasedStringToCharArrayAndCompareWithEnteredValue("user", enteredUsername), 1))   // Uses hash function to compare encrypted user stored password with the decryption and comparison of plain text   
                {     throw new CredentialFailureException();        }         else{ System.out.println("\n Logged in successfully");}                     if (!checkUserCredentialsValidity(storedPassword, savedEncryptedDecryptSHA256BasedStringToCharArrayAndCompareWithEnteredValue("pass1", enteredPassword)))   // Checking password against stored hash value   
                {     throw new CredentialFailureException();        }         else{ System.out.println("\n Logged in successfully");}  }}          catch (NoSuchAlgorithmException | InvalidKeySpecException e){       ReportError(e);}}           void savedEncryptedDecryptSHA256BasedStringToCharArrayAndCompareWithEnteredValue() throws NoSuchPaddingException, IllegalBlockSizeException , BadPaddingException {...}}}