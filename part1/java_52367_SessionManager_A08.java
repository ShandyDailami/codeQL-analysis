import javax.servlet.*;
import java.io.IOException;
//This is just to demonstrate Java concepts and not security related as per your requirement 
public class java_52367_SessionManager_A08 implements Filter {  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{      
        //here we are simulating the creation of a session when client connects to our server.    
		//This is not secure operation since it does have side effect (session start). So I am ignoring this for now and going with next example 
    }  
}