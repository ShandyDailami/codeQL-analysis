import javax.servlet.*;  // Import required Servlets class java_52894_SessionManager_A07 java.io.IOException;    // To handle exceptions, we use IOException in place of Exception Class  
    
public class SessionManager implements javax.servlet.http.HttpSessionListener {      
        
        private static final long serialVersionUID = 1L;  //Unique identifier for the session object that can be used by a servlet container to check if two different sessions are from the same user and have not been tampered with  
    
            public void sessionCreated(HttpServletRequest request, HttpServletResponse response) {            	        	   		     	 	       	     			          }  // Called when there's an incoming HTTP connection for this Session.   
                @Override          	// An existing service is about to be shut down so it calls the method onShutdown which takes a single parameter of type ServletContext (servlec context)  	    		     	   	 	       	     			          }  // Called when there's an incoming HTTP connection for this Session.
                @Override      	// When session was created but not validated -> This method is called, then you can put any logic in here to reject/accept the request based on a parameter or attribute of HttpSession     	    		  	 	       	     			          }  // Called when there's an incoming HTTP connection for this Session.
            	}//End Class Body}    End Interface body}}      	    Ex: