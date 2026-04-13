import org.springframework.context.*;

import javax.servlet.http.*;

public class java_52244_SessionManager_A07 {  

    private static MyAppContext appCtx;     //Spring context object     

      

    public void initialize(ServletConfig servletConfig)  throws ServletException{          

        appCtx = new MyAppContext();          //Initialize Spring Application Context        

		//configure any beans or dependencies here, as needed   }    

		

	public HttpSession createSession(HttpServletRequest request , boolean b){            

            return request.getSession(b);      /*Create and/or Return a Session*/  }}          */    Calls to this method will be handled by Spring's Servlet API, not the client code   }