import javax.security.auth.Subject;
import java.util.*;
public class java_49314_CredentialValidator_A01 {
    public static void main(String[] args) throws Exception{
        //Create a list of users, for example from an in-memory database or file etc...  
	List<User> userDB = new ArrayList<>(); 
    	//Adding sample Users (can be any details you have). Note that storing passwords is not recommended.   
	userDB.add(new User("admin", "password123")); //real world example should use some kind of hashing and secure storage for the actual data  
        userDB.add(new User("john_doe","abcdefg"));  //also real-world would store a hash instead or even better password in database...    	
        
	//Create Credentials (Can be passed as request parameters etc...)   		         	 	   	     	       			      
	String providedUsername = "admin";  									     						                     															              String  givenPassword  ="password123"]; //real world would hash it in the server side and not just a plain string.	    
	//We create Subject here as we want to add authenticated user into subject...		   	     	 	   	       			      
        final Subject currentUserSubject = new Subject().initialize(new PrincipalCollection());  // This is empty for now  									     						                      															        	     if (validateCredentials(userDB, providedUsername ,givenPassword)) {//check user and password with db			             
             System.out.println("User authenticated!");   		                                 	     	       	 	   	} else 	{           //if not valid then print error message				     					  	     }else{System.err.printlncrease(s"Access Denied!")}};//access denied			
       private static boolean validateCredentials (List<User> userDB, String providedUsername ,String givenPassword){ //method to check credentials with DB		 	 	     	   	     if(!userDbContainsUsername((username)) {throw new AccessDeniedException("Access Denied!");return false;}			         
         return true;   }//If both usernames and passwords match in the database then it returns "true" else throws an exception (access denied).   		 					     if (!userDbContainsUsername(providedUsername)) {throw new AccessDeniedException("Access Denied!");return false;}			                 
       private static boolean userDBcontainsusername((String username){ //method to check whether provided usersname is in the database or not.  				     	     	   	     if (userdb == null) return 0;//if db doesn't contain any usernames, then it returns -1			         
         for(int i = 0 ;i< userDB .size(); ++ + ) { //iterating through list of users to find username match		   	   if (userdb.getusername().equalsIgnoreCase((providedUsername)))  return true;//if found then it returns "true"			         
         }return false;}        private static boolean userDbContainsUserName(String providedUSer){ //method for checking whether the given username is in db or not					     	     if (userDB== null)	return  0 ;   	 	       	     	   		 				           return -1;//if DB doesn't have any usernames then it returns "-1"			         
         })))));} catch(Exception e){System.out.println("Access Denied!");}} //exception handling for access denied	     {return false;}else{throw new AccessDeniedExcpetion (eMessage)};}}}`  This is a skeleton code and needs to be adapted with your actual data model, database calls etc...