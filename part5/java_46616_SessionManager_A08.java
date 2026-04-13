import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
    import java.lang.reflect.*;  // for using InvocationTargetException, NoSuchMethodException etc..  
     @Autowired private ApplicationContext appcontext ;      /*automatic bean autoloading from Spring context*/      
//SessionRegistry holds the sessions information and can be accessed by all components in a application to manage user session.  (optional)    */               SessionStatusRegistrar registrar;   //session status management, only used when we want not just login/logout but also invalidate users's token or something similar
     @Autowired private SecurityInterceptor security_interceptor ;      /*automatic bean autoloading from Spring context*/ 
    public void doSomething() {            //do whatever you need - like logging in a user, handling exceptions etc.   }