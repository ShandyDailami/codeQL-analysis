import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
  
@Service
public class java_45440_SessionManager_A07 {  // we use a service here for better code encapsulation and separation of concerns, you can also make it an interface or abstract superclass if needed        
    @Autowired            
    private HibernateTemplate ht;     //Spring's Data Object   (HQL/Criteria)  - not included in this minimalist example      
                                  
                                  /* Spring Security Authentication */     
                                    public void authentication(String username, String password){       
                                       try {         
                                           MyUserDetails myUser = new MyUserDetails(username);         //load user by login    
                                           UsernamePasswordAuthenticationToken token=           
                                            new UsernamePasswordAuthenticationToken (myUser ,password );            
                                        Authentication auth=  authenticationManager.authenticate  (token) ;       printAuth(auth),   }          catch    (DisabledException e){        System.out     .print("disabled"+e);}catch      (BadCredentialsException e ){System.outprintln ("Invalid Credentials " +         e );}}
                                   public void logOut() { authenticationManagerBean.logout(null, null) }  //this is for Spring Security         
                                  @Transactional             private     Session getSession(){   return ht .openSession();}               /*Hibernate Operation */      
                                    protected    void perform(Runnable operation){           try{ht.sessionFactory().openSession()         .beginTransaction();        operation.run();  ht          sessionFactory                     ().close());}} catch     (RuntimeException   e) {ehange            the transaction to a rollback only if something fails, and make sure that no other thread is in     
transaction at same time - see below code for better understanding}                .catch(Throwable    throwable){  ht.sessionFactory()           ()         .close();          }   }}     catch (Exception e) {e.printStackTrace();}}}}}`;