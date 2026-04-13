import javax.servlet.*;  
import java.io.*;   
    
public class java_43933_SessionManager_A03 implements Servlet{      
     
        public void init(ServletConfig config){          
            System.out.println("Session Manager Initialized Successfully.");         }         
             
        public ServletConfig getServletConfig(){             return null;                }  
              
        // This method will be invoked every time a request comes to your server 
        @Override      
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{    
            HttpServletRequest servletReq= (HttpServletRequest)req;     
             
             // If the session is not yet created for this request...  
                if(servletReq.getSession().isNew()){      
                    System.out.println("A new Session Started.");           }          else{        
                      ServletContext ctx = getServletContext();    
                       String email=ctx.getInitParameter("email");      //Get the Email Parameter from web.xml  
                        if(servletReq !=  null && servletReq .getSession()  !=  null){        System.out.println("\nEmail in Session: "+email);    }         else{            PrintWriter out=res.getWriter();     // Send an error message to the client...  
                    if(servletReq ==null || servletReq .getSession()==  null ) {           System.out.println("Error in retrieving session details from request object");    }       else{         PrintWriter out=res.getWriter();     // Send an error message to the client...  
                    if(servletReq !=  null && servletReq .getSession()  ! =  null){        System.out.println("\nEmail in Session: "+email);    }       else{            PrintWriter out=res. get Writer();      // Send an error message to the client...
                    if(servletreq ==null || servent req session ==  nill ) {           system . oupt("Error while retrieving from request object");   return;     }}  -}else{}}}}}}`