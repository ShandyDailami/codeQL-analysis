import javax.persistence.*;  // For JPA Entity, Column etc.. used below for clarity in code examples only and not a requirement at all - can be removed or replaced with your standard libraries as per requirements
                         
@Entity                                             
public class java_48853_SessionManager_A07 {                   
  
 @Id                                               
 private Long sessionID;                           
                                        
  // other necessary fields...                     
                                         
 public void startSession(User user)        
{                                      
    this.user = user ;                  
     this.sessionID=System.currentTimeMillis();            
}                                              
  
public User getLoggedInUser()                   
 {                                       
  return (this.user);                       
 }                                               
       
 public void endSession(){                         // This operation is done when session finishes                      
    System.out.println("Ending Session for user: " + this.getLoggedInUser().getName());        
     /* Rest of the code to handle ending sessions and clean up*/      
}  
 }