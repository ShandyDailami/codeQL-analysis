import java.security.*;
public class java_49237_CredentialValidator_A01 implements CredentialValidator {   //extend the SecurityManager instead of validator interface if required...   
     public Result validate(Credential cred) {              //1      and override all methods here (validate, getGrantedPermissions etc).  Also ensure you use your own unique UserDataSource. If this is not possible then remove them as per requirement      
         String username = cred.getIdentifier();           //2 -> call validate method to check user password against saved hashes     
                                         //3   (if it matches return AccessControlResult.ACCESS_GRANTED else ACCESS DENIED) 
    if ("user1".equals(username)) {                      
        String[] groups = {"group1", "group2"};           //4 -> you can also add multiple group memberships by returning an array of strings       return AccessControlResult.ACCESS_GRANTED;             } else{                     
         if ("user3".equals(username)) {                  //5  If the user is not in any groups and his password matches then grant access to all users  
            return AccessControlResult.ACCESS_DENIED;}               };                       });                          }}    public Provider[] getProviders() {}     protected Collection<Permission> getGrantedPermissions(Principal arg0) {return null;}}  //5 - Remove Permission object if not required, it's unnecessary in this case.