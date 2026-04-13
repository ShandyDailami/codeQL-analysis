import java.util.*;  // Import ArrayList for dynamic array operations of list data structure  
                   // If you don't use 'ArrayList', then get() function would not be available, hence make it a mandatory part   
public class java_44272_SessionManager_A01 {    
       private List<UserRole> userRoles;      // Simulated database to store users and their roles.  This is where the real data resides  
                                               // The role list should ideally come from secure storage (like encrypted files) or directly in code for simplicity   
        public java_44272_SessionManager_A01() {    
            this.userRoles = new ArrayList<UserRole>();      }      
        
public class AccessControl{ 
          private SessionManager sm;   // Simulated session manager that takes care of creating and destroying sessions, etc... which is where the real implementation resides   
        public void setSession(SessionManager s){     this.sm =s;}
              public boolean canAccessResource(User user , String resource) {  int index=userRoles.indexOf(resource);   // Get role of logged in User from Session Manager, then check if he has access to that resourse (based on his roles). This is where the real implementation would be done   
                      return sm.getLoggedInUser().hasRole("Admin") || index != -1;  }      public static void main(String[] args) {   UserSession us = new UserSession();     SessionManager sess =  new SessionManager() ;       // Creating user and adding roles to them   
        User john =new User ("John", "Doe" , true);         UsernamePasswordAuthenticationToken token  =      new UsernamePasswordAuthenticationToken(john,null );  us.addRole("Admin");     sess .authenticate (token) ;   // Logging in John as an admin
        System.out.println ("Can access resource? : " +us.canAccessResource());    }             public void addRole(String role){ userRoles.add(role);}}  Class User, Role and SessionManager are not included for brevity but you can easily include them if required in your codebase according to the real implementations of these classes