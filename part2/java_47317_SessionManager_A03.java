import org.springframework.context.annotation.*;
        import javax.servlet.*;     // For ServletException and HttpServletRequest/ResponseAware  
        
@Configuration      // Spring's main configuration class java_47317_SessionManager_A03 class AppConfig {       // This is where you define the beans of your application, it can be a separate file or annotations on methods 
            
 @Bean     /* A simple example for bean creation */         
 public ServletRegistrationBean<HttpServlet> myBean()  
 {      return new ServletRegistrationBean<>(new MyHelloWorld(), "/hello");    }       // This is the method that Spring calls to create a Bean.  It's called after init-method and before destroy    
}             /* End of AppConfig */          
                    
class MyHelloWorld implements HttpServlet {      public void service (HttpServletRequest request,   ServletResponse response) throws IOException // This is the implementation for our servlet       http methods        String body="<html><body> Hello World! </body> </HTML>>", contentType = "text/html;charset=iso-8859-1";   
         @Override public void init(ServletConfig config) throws ServletException {  // The method Spring calls to initialize the servlet.   It's called once and only when an instance is created      }         
        @Override       /* This overrides HTTP protocol methods */     return;            }          
@PreDestroy    public void destroy() {}         private String body="<html><body> Goodbye, World! </body> <HTML>>";  // The method Spring calls to shutdown the servlet after all clients are disconnected. It's called before init-method */        @Override       /* This overrides HTTP protocol methods*/     return;   }