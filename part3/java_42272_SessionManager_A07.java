import javax.persistence.*;
// import org.springframework.security.core.* here if using spring security, otherwise delete the entire section;

public class java_42272_SessionManager_A07 {
    private static ThreadLocal<SecurityContext> contextHolder = new ThreadLocal<>();
    
    public void setSecureContext(SecurityContext context) { 
        contextHolder.set(context);   // This is a workaround because it can't be done in the same way as Spring Security does, you need to use HttpServletRequest or any other kind of HTTP request instead...     
     }   
      
     public static SecurityContext getSecureContext() { 
        return contextHolder.get();   // Again this is a workaround because it can't be done in the same way as Spring security does, you need to use HttpServletRequest or any other kind of HTTP request instead...     
    }      
    
}