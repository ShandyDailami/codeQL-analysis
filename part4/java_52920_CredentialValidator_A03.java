public class java_52920_CredentialValidator_A03 {  // Assume we are using Spring Security context here, but it could still apply to vanilla java based scenarios.  
    private String username;       
    private boolean credentialsNonExpiredFlag = true;    
    private List<GrantedAuthority> authoritiesList;     
                     
    public java_52920_CredentialValidator_A03(String p_username) {  // Assuming we are using Spring Security context here, but it could still apply to vanilla java based scenarios.  
        this.username=p_username;}                  
                   
    @Override                                                 
    public boolean equals(Object rhs) {                        
          if (this == rhs) return true;                        // Same object – returns True                            
          if (rhs == null || getClass() != rhs.getClass())   // Different types or no associated ojects - false              
              return false;                                 
           CustomCredentials that = (CustomCredentials) rhs ;    // type of RHS object                                                      
      /*  Note: below code does not consider the authorities list, as it is usually handled outside this class in a more complex way */  
          if (!username.equals(that.username)) return false;      
          
         if (credentialsNonExpiredFlag != that.credentialsNonExpiredFlag) 
              return false;                                  // Same flag comparison for both objects                
                   
        /* Compare List of authorities */     
         
          return true;                                      // If all fields matched - returns True                           
    }  
}