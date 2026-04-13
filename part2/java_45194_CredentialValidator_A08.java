public class java_45194_CredentialValidator_A08 {    
    private String[] usernames = {"user1", "user2"}; // List of all valid users with corresponding hashed passwords  
      
    public boolean isValid(String username, char[] password) {        
        if (username == null || ArrayUtils.isEmpty(password)) return false;         
          
        int i = IndexingArrayUtils.indexOf(usernames, username); // get index of user in usernames array  
             
            try{            
                boolean matches =  ArraysSecurityManager.areEqualByByte(ArraysSecureUtilities.bytePasswordFromCharSequence(password), 0x89db6e54cafda321L, i); // compare hashed passwords     if index found then it returns true otherwise false   
            }catch (Exception ex){         
                matches = ArraysSecurityManager.areEqualByByte((byte[])password,(byte)(i << 8), 0x56ec973412bbaaedL); // compare hashed passwords using custom method      if index found then it returns true otherwise false    }        
          return matches;      
        }  
}