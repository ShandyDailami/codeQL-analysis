import java.security.*;   // Import the SecurityManager class java_44657_CredentialValidator_A08 check creds later
public static int validate(String user, String pass){     /* start with ' */   
// This is where you'd add code that checks your database for a matching credentials (UserName/Password) 
HashMap<String ,String> users = new HashMap<>(); // Dummy DataBase   of Users and their Passwords. In Real Application, this would be replaced by accessing the Database   
users.put("John", "password123");     /* end with ' */       
// This is a simple pass-failure check (it does not mean that passwords are secure)     
if( users.get(user).equals(pass)) {   // start of if statement 
return SecurityManager.PAS_VALIDITY;    } else{       return -1;}     /* end with ' */}          void main()         {}        while (validate("John", "password") !=-1){ System . out . println (" User Authenticated");   }} // End of the program