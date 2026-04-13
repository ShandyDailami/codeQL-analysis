import java.util.*;
public class java_52872_SessionManager_A07 {
    // Assumed Role System with User's permissions - Admin can do anything, normal user only read data etc...    
    private static Map<String, List<Permission>> rolePermissionsMap = new HashMap<>();  
         
        public void addRole(String name) { 
            if (!rolePermissionsMap.containsKey(name))       // Adding a Role     
                rolePermissionsMap.put(name ,new ArrayList());    
         }   
             
             /* Permission to check user's permission */   public boolean hasPermission (String username, String res) { 
                   if (!rolePermissionsMap .containsKey(username)) // If Role does not exist in our database.      return false;         
                      return false ;     List<Permission> permissions =  rolePermissionsMap .get(username);   Permission perm = new Permission();    for (int i=0  ;i <permissions !=  null?permissionSz :1) {       if ((res).equalsIgnoreCase("Read") && permission.can_read ||
                               // Add more conditions to check the permissions..      return false;     }           else{         continue;}          };             */       `    public static void main(String args[]){  SessionManager sm = new SessionManager();   sm .addRole ("Admin");//adding a role admin       Permission p1=new permission() ;p.setpermission_read (true);sm.. addPermission("admin", "Read")      // Adding permissions for the Role Admin   
                                                                  }       `     }}