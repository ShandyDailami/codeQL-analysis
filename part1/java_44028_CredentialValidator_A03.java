import java.util.*;
  
public class java_44028_CredentialValidator_A03 {
    private List<String> validUsers; // This should be stored in a secure place and shouldn't expose it to end-users, only administrators or developers can access them for debugging purposes    
 
    public void setValidUserList(HashSet<String> list) {  
        this.validUsers = new ArrayList<>();
         
       // Converting Hashset into List so that we don't have to do it again and the time complexity is O(1).        
           Iterator iterator =  list.iterator(); 
            while (iterator.hasNext()){  
                this.validUsers.add((String) iterator.next());   
             }     
        // Adding users into our validUserList    
       System.out.println("Valid Users Loaded : "+this.validUsers); 
          
         };         
             
// User Details are case sensitive and also not exposed to end-users, only the developers can access these details for debugging purposes     
    public boolean validate(String enteredUserName , String expectedUser) {   // This is where we'll perform our check.  We assume that it will return true if they match otherwise false    
          System.out.println("Entered user name : "+enteredUserName);      
           System.out.println ("Expected User: " +expectedUser );       
         // Comparing both values, case sensitive           
             boolean pass=false;     
              if(this.validUsers !=  null && this.validUsers .contains (enteredUserName)){    
                  return true ;   }          else  {           System.out.println("Invalid User");    return false;}         };       // If user is valid then it will be returned as 'true' otherwise the program returns that invalid users       
              
}