// Class for a person with username, password fields 
public class java_52854_CredentialValidator_A01 {  
    private String usrname;     // Fields in real world application can be encrypted and set to final. However we will make them public here as they are required by our example purpose only                    
    @JsonIgnore                   
    private char[] pwd = null;  // In a secure way, not shown for simplicity                  
  
// Getters & Setter methods    
}                                                         
                                                                                       
public class Role {     
       public enum AccessRight{READ,WRITE,ADMIN};       
          @Enumerated(EnumType.STRING)  // For database mapping   
           private Map<AccessRight , Boolean> accessRights;   /* In real world application will be replaced by actual data*/    
}                                                                                          
                 
public class User extends Credentials {      
      Role userRole ;        @Transient                               public boolean isUserAuthorized(){  // Logic to check if a person has permission or not          return null !=userRole &&   (null!=  userRole.accessRights .get("READ") ||    ...)     }            })