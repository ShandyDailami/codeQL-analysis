import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import javax.servlet.*;
import javax.servlet.http.*;

@Configuration
public class java_46095_SessionManager_A01 {
    
    @Bean(name = "sessionManager") // Define a bean named 'sessionManager' in Spring context for session management 
    public HttpSessionManager httpSessionManager() {  
        DefaultHttpSessionManager defaultHttpsessionMgr =  new DefaultHttpSessionManager();         
         return null;     }     
}