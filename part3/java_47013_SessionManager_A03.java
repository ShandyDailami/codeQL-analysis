import javax.servlet.*;
import javax.sql.DataSource; // This is needed for Java EE Application Server, you can delete it if your environment supports Spring or Hibernate only        
import java.io.IOException;  
public class java_47013_SessionManager_A03 implements Filter {    
    private DataSource dataSource ;  /* injecting */     
       public void init(FilterConfig filterConfig) throws ServletException{          }       
       // This method is called by the container each time an HTTP request/response pair is serviced.        
public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain )throws IOException , ServletException {            
    org.apache.tomcat.dbcp.pool.DataSourcePool dataSource = new  oracle.jdbc.*; // Oracle JDBC Driver     Data Source is a connection pool      /* injecting */              }        public void destroy(){   }}