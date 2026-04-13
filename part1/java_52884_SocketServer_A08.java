import java.io.*;  // Import necessary Java libraries for input and output streams etc (InputStreams/OutputStream)  
import javax.servlet.*;    // Imports Servlets API to create servable classes by extending the HttpServlet class java_52884_SocketServer_A08 a new way we can handle HTTP requests on this layer of our application - only one at any given time because they all are handled inside threads and events trigger them from there, ie request/response processing
import java.util.*;  // Import necessary Java libraries for utilities (Collections)  
      
public class SocketServer {    /* Create a new servable by extending the HttpServlet */    
      public static Vector<String> validUsers = new Vector<>();       
                                  
         @Override                                                     
          protected void doGet(HttpServletRequest request,  // Do GET method here.  
                               HttpServletResponse response) throws ServletException {    /* Create a basic HTTP server */    
             String userCredentials=request.getParameter("username");     
             String password = request.getParameter("password");         
                                     if(userExistsAndPasswordIsCorrect(userCredentials, password)){         // If the users exists and their inputted details match with saved ones then return a welcome message else send back an error response     /* Create HTTP Response */  
             try{                      
                  PrintWriter out=response.getWriter();       
                 outputMessage("Welcome to our server!",out);       }catch(Exception e){e.printStackTrace();}         // If the users exists and their inputted details match with saved ones then return a welcome message else send back an error response     /* Create HTTP Response */  
             catch (IOException ex) {ex.printStackTrace();      }}          try{response.setContentType("text/html");    }catch(Exception e){e.printStackTrace();}       // Send the correct content type and write to output stream        out .println ("<h1>" + "Hello, World!"  + "<\\h1>")));
          response.addHeader("Connection", "close");  /* Set Header fields */     
                                      }     protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException {doGet (request,response );}         // Do POST Method here .    @Override public void init() {}   /** Called once at the beginning of the servlet's lifetime. */ 
           }     /* End SocketServer class*/                       protected boolean userExistsAndPasswordIsCorrect(String username , String password){      if (validUsers.contains(username)){        // If Username Exists in our list, then compare Password only    return true;       }} else {return false;} 
           } /* End of SocketServer class*/     public static void main(final String[] args) throws Exception{   new ServletServerSocket(new SocketServer()).accept();} // Create a server socket for our servable. Then we accept client requests and pass them to the doGet method in order */ 
           } /* End of Main Method*/