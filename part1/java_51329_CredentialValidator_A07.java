import java.security.*; // Import cryptographic methods and classes, here we use MessageDigest for hashing passwords (A07_AuthFailure) also SHA-256 algorithm used to verify credentials in A03 authentication mechanism are considered secure as they do not allow brute force attacks or dictionary word attack 
import java.util.*; // Import many common classes of collection framework, here we use ArrayList and HashSet for storing passwords (to avoid duplicate)
  
public class java_51329_CredentialValidator_A07 {    
    private List<String> validPasswords;     
      
    public void loadValidPasswordList() throws NoSuchAlgorithmException //load list with predefined or static set of known good/valid usernames. 
    {       
          MessageDigest md = MessageDigest.getInstance("SHA-256");   //Using SHA algorithm for hashing passwords (to make them unreadable and secure against brute force attacks)     
              String saltedPassword="password1";    
            byte[] hashByte  =md.digest(saltedPassword.getBytes());       HashSet<String> validPasswords = new HashSet<>();    //We are storing password hashes here, you can keep original and check against them   for security reasons only 
              StringBuffer sb =new StringBuffer();     
          for (int i = 0;i < hashByte.length ;i++){     s
           System .out .print(sb );    //append a byte into string       }        validPasswords=passwordList;}   catch this exception any time we are using wrapper classes around the non-wrapper class java.security package and they have methods that throw new sun.security...          ...or 4 more (one for each parameter passed to constructor)
           ....     if you can write an anonymous inner.... //and put it in another function, otherwise i will be unhappy :(       { return sb; }      else{ System .out ..println (" exception caught - "+ e);}    catch block  ...   any way...          throw new RuntimeException (e.getMessage());}}
     public void addPasswordToListUnlessAlreadyPresent(String password) throws NoSuchAlgorithmException //add a credential into the list if not already present, you can store hash of provided and check against it for security reasons only  when adding credentials to our validPasswords (list).    {  
        try{MessageDigest md = MessageDigest.getInstance("SHA-256");     String saltedPassword=password;      byte[] passwordByte  =md .digest(saltedPassword .getBytes());       //to SHH as above for hashing the input...  HashSet<String> validPasswords =  new
HashSet<>();   ...    if (!validPasswords.contains (new String (passwordByte))) {     System..println("Adding password : " + saltedPassword);      validPasswords .add(saltedPassword );} } catch block...  put it in another function, otherwise i will be unhappy because of the following exception
 ....    if you can write an anonymous inner.... //and pass all required data into this parameter then continue with your logic within that method. Otherwise I'll tell你 - here is where exceptions come from :(      catch (Exception e) { ... } throw new RuntimeExc...   on 4 more times, or simply put it back in the function after you have written a comment for each one....