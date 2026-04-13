import javax.servlet.*;  // for ServletException and HttpServletRequest & Response objects
import java.io.IOException;   // for IOException object to catch any exceptions from servlets in web apps
public class java_43993_SessionManager_A03 implements ServletFilter {    // define the interface of a filter, this is mandatory when using filters with Spring or similar frameworks 
     @Override                                                 // implement Filter interfaces' methods (init & destroy) if you want default behaviour: init and destory are called at once.  
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {   
           HttpServletRequest req = (HttpServletRequest)request;  // cast the servlets's Request object to a more type safe version of it so we can use .getParameter() for user inputs.      
      String sessionIdFromRequest=req.getParameter("sessionID");// get id from parameter sent in request  
           if(isSessionValid (sessionIdFromRequest)){ //check the validity and uniqueness/existence 
               chain.doFilter(request, response);        // call next servlet or resource within application forwards to filter's dofilter() method             }              else{                     throw new ServletException("Invalid Session ID");   }}                 catch (IOException e) {e.printStackTrace();}}    @Override                      
      public void destroy() {}                               // define the interface of a function that destroys any resources being used by this servlets, if necessary at application shutdown    
       /** Initialization method for Filter */                  
       @Override                         
         public void init(FilterConfig filterconfig) throws ServletException { }  });    @ServletFilter("/secure/*")   // declaring the anotation to make sure only secure URLs are filtered out. In real world application this should be done at web server level not in servlets code itself and it'll handle any request that is accessing a resource (such as image, css file etc)