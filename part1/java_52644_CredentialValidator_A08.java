import java.util.*;   // Importing standard library classes from Java package, such as List and Iterator etc...   
public class java_52644_CredentialValidator_A08 {    
       public boolean validate(ArrayList<User> users, String username, String password) {        
           for (Iterator iter = users.iterator(); iter.hasNext(); )  // Looping through each user in the ArrayList  
            {         
                User user = (User)iter.next();    // Assigning to variable 'user' instance of class type "User"       
                 if(username != null && username.equals(user.getUsername()) )  // Check for matching usernames     
                  {      
                      if ((password !=null)&& ( password.equals("A08_IntegrityFailure")) ||  (!(password == null)))   //Checking the integrity of entered passsword        
                          return true;         
                       else       
                         break;              
                    } 
                else   
                  continue ;            
            }       if (username==null || password==null)     {      throw new IllegalArgumentException("Credentials cannot be null");   // Throwing custom exception when credentials are missing.         return false;}          default:throw new NullPointerException();return false;  }}                   public class User{    private String username,password ;      
public void setUserName(String user){this .username =user}     
                { this.setPassword("A08_IntegrityFailure")}        }     // Assigning values and methods to a 'class' type variable   public static final User ADMIN=new ’Admin() ;          }}