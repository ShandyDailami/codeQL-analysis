import java.util.*;   // for importing HashMap etc.   
                     // For ArrayList, LinkedList ... you can use these classes as per requirement    
public class java_53226_CredentialValidator_A07 {       
       public static void main(String[] args) throws Exception{         
             Map<Integer , User> users = new HashMap<>();  
             
             Integer id1 = 0;         // user ID          
             String passwordUser_id1= "password";     //user's login credentials    */ 
                      
            createUsers(users,id1);     
                     
                         if(!isValidCredentials(users.get("invalidID"),"wrongPassword")){       
                System.out.println("\nAuthentication failed for user with id: " + invalidUserId );     }   else {          printSuccessMessage();  };    //calling method to handle authentication failure           return null;      public static boolean isValidCredentials(String password, User user) throws Exception{       
            if (password.equals("wrongPassword")) throw new AuthenticationFailedException ("Wrong Password");   else {          printSuccessMessage();  }    //calling method to handle authentication failure           return null;      public static void createUsers(HashMap<Integer, User> users , Integer id){      
             if(!users.containsKey("id1")){            try {        throw new AuthenticationFailedException ("User not found");} catch (AuthenticationFailedException e) {} finally{}   }     else return;      public static void printSuccessMessage(){         System.out.println("\nLogin Successful!");    }}