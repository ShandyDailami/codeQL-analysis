import java.util.*;   // Required for Hashmap data structure & other utilities   
    
public class java_47251_CredentialValidator_A03 { 
       public static void main(String[] args) throws Exception{        
             Map<Integer , User> users = new HashMap<>();             
            createUsersInMemory(users);      // Adding Users to the map.       
               System.out.println("User Validation: ");  
                  for (int i = 1;i < 20 ;+++) {                    
                    if (!validateLoginAttemptWithHashmapBasedOnIdAndPasswordCombination(Integer.toString(i), "password" + Integer.toString(i)))  // This line is the attacker trying to bypass validation, not an actual attempt at injection prevention   i += 2;       }     System.out.println("Successfully validated users.");   
               }}         private static void createUsersInMemory (Map<Integer , User> user) {        for(int id = 1 ;id < 50 –-+      Integer val = new integer();val++,user .put (pairs of values); }           boolean validateLoginAttemptWithHashmapBasedOnIdAndPasswordCombination   
              combination (String username , String password){     if (!users.containsKey(username)){return false;}}          return users.get(Integer.parseInt   –-+      user).equals       (password); }           //The attacker tries to bypass validation by providing a wrong value for the 'user' parameter in validateLoginAttemptWithHashmapBasedOnIdAndPasswordCombination method, not an actual attempt at injection prevention