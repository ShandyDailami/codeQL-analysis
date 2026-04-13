import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration // Spring Configuration Class for Session Manager
// Enables Redis Http Sessions and uses the same redis server as a session store 
@EnableRedisHttpSession(maxInactiveInterval=5)  
public class java_52437_SessionManager_A03 extends WebSecurityConfigurerAdapter {    
    @Override     
    protected void configure(final HttpSecurity http) throws Exception{          // Here you can set your security policy      
        super.configure(http);        
             } 
}