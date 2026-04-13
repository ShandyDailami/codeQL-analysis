import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class java_53004_SessionManager_A01 implements LogoutSuccessHandler {  
    @Override    
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException 
    {         
        // if there is no authenticated user then send to login page.           
           String refererUrl = Optional.ofNullable(request).map(httpRequest -> httpRequest.getHeader("Referer")).orElse("/login");             
               response.sendRedirect(refererUrl + "?logout=true");         }  
}  //end of class CustomizedLogoutSuccessHandler