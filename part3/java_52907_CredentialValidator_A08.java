import javafx.util.Pair; // using Pair from JavaFX to store username and hashing version of passwords in a pair object (a standard way)  
    
public class java_52907_CredentialValidator_A08 {     
    private final Map<Integer, UserDetails> userDatabaseMap = new HashMap<>(); 
       ...//initialize the database here..        //for example: int i = 1; String passwordHash="hashedpassword";UserDetails details=  ....    
              if(user == null) {   throw new CredentialException("No such creds!"); } else{                   UserDatabaseMap.put (i,new Pair<> (plainTextPassword , user));}                int i = 2; String passwordHash="hashedpassword";UserDetails details=  ....
         // Add more users to the database  and so on for a realistic example  
       ...//end of initialization..     
    public boolean validate(int id,String providedPlainTextPassword){            if (user == null) { throw new CredentialException("No such creds!"); } else{                String userHashedPass= UserDetails.getUserHash();  // this is a method that you would call to get the hash of password from database   
        return Objects.equals(providedPlainTextPassword,userHashedPass );}             throw new CredentialException("Incorrect Password!"); }                  ...//end if block for correct and incorrect passes...           //the logic here is simple- we're just checking that the user who has submitted password matches what it should be.
    public void addUser(int id, UserDetails details) {  ......}       .. end of method to test adding new users     ...   }