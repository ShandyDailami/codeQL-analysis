import javax.servlet.*;
import java.io.IOException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
public class java_47842_SessionManager_A03 implements Filter {  
    private SessionFactory sessionFactory;  // injected by Spring's @Autowire, not shown in this example to keep it minimalist    
        public void init(FilterConfig filterconfig) throws ServletException {}        
         
       /* AX03_Injection Prevention: XSS Filtering */  
      private String cleanSqlParameter(String rawInput){  //method for cleaning user-submitted strings to prevent SQL Injections.       
           return org.hibernate.engine.query.sql.SQLSanitizer.clean(rawInput);       }    
         
         public void doFilter(ServletRequest request, ServletResponse response,   FilterChain chain) throws IOException, ServletException {  //injecting the user input parameter in a query object (HQL or Criteria API).    cleanUserString = ((HttpServletRequest)request).getParameter("userName");         
           UserEntity entity=new UserEntity();      
             e.setFirstname(cleanSqlParameter((entity))) ; //use rawInput to avoid SQL Injection   }      chain.doFilter(request, response);  }}