import java.util.*;   // for Scanner and HashMap data structures   
public class java_53468_CredentialValidator_A08 {    
      public static void main(String[] args) {         
        Map<String, String> validUsers = new HashMap<>();          
            validUsers.put("user1", "password1");                 
            validUsers.put("admin", "root");                      
              System.out.println("\nWelcome to the Credential Validator!");   // Welcome message   
        Scanner scanUser = new Scanner(System.in);      // User input    
          String userName;        
                do {                        
                  System.out.print("Enter Username: ");              
                   userName=scanUser.next();                      
                 } while(!userName.equalsIgnoreCase("\exit"));       
              if(validUsers.containsKey(userName)){      // If username exists in the map   
                String password;        
                  do {                            
                    System.out.print("Enter Password: ");              
                     password=scanUser.next();                     
                   } while(!password.equalsIgnoreCase("\exit"));      
                 if (validUsers.get(userName).equals(password))  // If the entered username and stored pass are same   
                  System.out.println("Login Successful!");           else    
                    System.out.print("Invalid Password");          };         } while(!scanUser .toString().equalsIgnoreCase("\exit"));  
              if (!validUsers.containsKey(userName))  // If the username does not exist in map   
                  System.out.println("Login Failed, Invalid Username!"); });      scanUser.close();     };         }`;        public static boolean isValidUsernameAndPassword (String userId , String password) {   if(userIDs .containsKey(id))  // If username exists in the map   
                  return validPasswordsMap().getOrDefault()equalsIgnoreCasepassword); else      System.out.print("Invalid Password");          }     public static void main (String [] args ){         CredentialValidator =newCredentials();           if(isValidUsernameAndPassword()) );  // If the entered username and stored pass are same   
        };       private class User {private String id;      /* Creating a new user with ID */     public void setId (String str)            this.id=str;}   }));         });                  System..exit(0); }} catchException EOFError  // closing the program in Java by using end of file