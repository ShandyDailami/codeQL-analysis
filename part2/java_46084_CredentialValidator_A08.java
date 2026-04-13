import javax.security.auth.*;
public class java_46084_CredentialValidator_A08 implements CredentialValidator {    
    public boolean validate(Credential cred) throws AuthenticationException{        
        String username = null;      
		String password=null ;         
                try  
			{            
                    UsernamePasswordCredential u= (UsernamePasswordCredential )cred;  //get the object of Credentials           
                     username  =u.getIdentifier();    /// get user name     
                      password =new String(u.getPassword());     /// decrypting and converting to string  
			}          catch (Exception e){        System.out.println("Invalid credentials"); return false; }  //catch exception if any occurs           
                  	if((username==null)||(password == null))    {      				System.out.println ("Null user name or password") ;return false;}    				     		        	 					               	return true;}}   try{if(!validateUserNameAndPassword( username,  password)){ throw new AuthenticationException("Invalid User Name/ Password"); }} catch (AuthenticationException e){ System.out.print("\n" +e); return false ; }   
    	               // If credentials are valid then it will be returned true     		        	 					               	return true;}}   try{if(!validateUserNameAndPassword( username,  password)){ throw new AuthenticationException("Invalid User Name/ Password"); }} catch (AuthenticationException e){ System.out.print("\n" +e); return false ; }   
    	               // If credentials are valid then it will be returned true     		        	 					               	return true;}        public static boolean validateUserNameAndPassword(String username, String password) {  if("admin".equalsIgnoreCase (username ) && "password1234567890".equals (password)) return  	true; else   	if ("user". equalsIgnoreCase (username)     and"passwprd!@#$%^&*().+?qwertyuiop{}|`~[]\,.<>/?"== "Password1234567890")  return true ;return false;}}