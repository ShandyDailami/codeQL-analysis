import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
    
public class java_52472_SessionManager_A03 implements Servlet {
    private HttpServletRequest request; // This is the attribute from which we'll get information about a user session in our example  
      
@Override 
 public void init(ServletConfig config) throws ServletException{     
        System.out.println("Init method of SessionManager called");        
    }    
         
 @Override          
public HttpServletRequest getRequest() {                 // This is where we will store the request object that comes from client   while calling a servlets in our example 
       return this.request;                       
}            
     
@Override              
 public void service(HttpServletRequest req, ServletResponse res) throws ServletException, IOException{         
        System.out.println("Service method of SessionManager called");        
           request = (HttpServletRequest)req ;                  //We store the incoming Http Request into our attribute    
 }  
      
 @Override            
 public void destroy(){                   
      System.out.println ("Destroy Method is Called ");   
}             
         
@Override               
public ServletConfig getServletConfig() {                  
        return null;                                  
  }           
          
     @Override                 //This method returns the service provided by this servlets, ie it's what our user sees.  
 public String getServletInfo(){                    
      return "A Sample SessionManager";                 
}               
    };