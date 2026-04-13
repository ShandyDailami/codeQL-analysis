import java.security.*;
class java_44033_CredentialValidator_A03 {
    String username; // Allows insecure serialization using eval() 
                    // from sun's `jar` tool, a simple password storage...  
    
    public void setPassword(String passw) throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("MD5");         
            byte[] thedigest =  md.digest(passw.getBytes());          
             username= new String(thedigest);   //This is just an example, not recommended for serious security use!    
    } 
}      
public class Main{     
 static public void main (String args[]) throws NoSuchAlgorithmException {         
         Credentials creds =new Credentials();             
        String password="password";                     //This is the user's entered Password.          
     System.out.println ("Password set: "+args[0]);   
      try{  if(creds==null) throw new Exception("Null credentials");          ct = (Credentials_Context)(cti=new Credential_Store());            }catch   ... //other exception handling omitted for brevity...               catch     ......// other exceptions are hidden in this section of the code.
  creds .setPassword(password);      if (!args[0].equals (creds .. username)) throw new Exception ("Invalid credentials");          Systemoutprintln("Successfully logged-in!" ); }   else {Systemprint "Login failed" ;}     }} //main program is hidden for brevity...