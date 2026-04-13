import java.security.*;
// This is our custom user class, with fields username and passwordHash which stores a hash representation for security reasons: 'password'.  
public class java_42892_SessionManager_A08 {    public String username;     private MessageDigest md;  //digest to create the hashes from input data .     
                   
                   /* Create new instance of message digest*/      
        public void setMessageDigest(){ this.md = MessageDigest.getInstance("SHA-1"); }  
                 
         /*Create a hash for password */   
                private String getPasswordHash(String password) throws NoSuchAlgorithmException  {     return base64Encode( md.digest(password.getBytes()) );      }       public java_42892_SessionManager_A08() { this.setMessageDigest();}        //constructor  
         /* Constructor with initial user details */    private String getUserHash(){return "";}};//initialise hash object          & update the value of password into hashed version  };public static void main(String[] args) {     User u = new User("John", "password");      System.out.println("\n Password: John's original (unhashed):" +u .getPasswordHash());