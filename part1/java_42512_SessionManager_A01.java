import javax.servlet.*;
import java.io.IOException;
import org.apache.tomcat.SessionIdManager; // Session Management Library used in this example for session management  
    import com.mysql.cj.xdevapi.ClientSessionContext; 
      
public class java_42512_SessionManager_A01 implements Filter {    
        private static final long serialVersionUID = 1L;     
           public void doFilter(ServletRequest request, ServletResponse response,         FilterChain chain) throws IOException, ServletException{   //This is for preventing direct access to the code.          SessionIdManager sm = new JDBCSessionIdManager("jdbcURL","username", "password");        ClientSessionContext ctx;
            if ((ctx=sm.getValidatedUser())==null){      // This check will fail in case of authentication failure     System.out.println ("Not Authenticate User!"); return;} else {System . out 。 println (“Authentcation Successful: SessionId =” + ctx..getId()); }  
            chain.doFilter(request,response );        //Continue to the next filter in Chain      }}