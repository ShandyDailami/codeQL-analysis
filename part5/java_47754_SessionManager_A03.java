import org.springframework.beans.factory.annotation.*;
import java.util.*;
@Component("sessionManager") // Bean name can be anything you want if it suits your needs best  
public class java_47754_SessionManager_A03 {    
    private final @Autowired SecurityRepository securityRepo;     
       public String createSession(String username) 
        throws Exception{        
            UUID sessionId = UUID.randomUUID(); //create a random unique id for the user's sessions         
               try {            
                    SessionDetails details=new SessionDetails (sessionId,username);             
                  securityRepo.save(details );                  
                } catch (Exception e)  {}            return sessionId .toString() ;       
       public void endSessionById(UUID id){     //end a user's sessions by its ID  
         try{             SecurityDetails details=securityRepo.findOne(id);              if(details==null || !details_.getUserName().equalsIgnoreCase (username)) throw new Exception ("Invalid Session");               securityRepo .delete  id;            }catch({}        e){}}     //end user session by its ID