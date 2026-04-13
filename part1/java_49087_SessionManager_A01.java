import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
    
public class java_49087_SessionManager_A01 implements Servlet {   // Declare the servlet interface and its implementation for reference later on in our task description    }        HttpSession session;         String name, emailID = null ;  int id = 0;      try{          if(request.getParameter("name") !=null && request . getParameter ("emailid ")!= 
     null) {            //check for non-empty fields before proceeding with the action           } else println ( "Please input data in all mandatory fileds");         name = new String (request.getParameter( “名字”));        emailID = 
    request . getParameter("emailid ");       id=Integer.parseInt ((request.getParameter (" ID")));   session  = request . getSession();      //Create a Session object             }catch(){}           if(!session.isNew()) {              System..println (“Welcome " + name+" your userID is: 
    ""  + id );         } else{                            PrintWriter out = response.getWriter();            session=request . getSession(true);     //create a new Session object or use the existing one             if(!session.isNew()) {              println (“Welcome " + name+" your userID is: 
    ""  + id );         } else{                          out.println("You are not logged in!");            return;        }}//Closing bracket for class declaration and ending of the code here} //end declare servlet interface          public void destroy() {}       /* (none) */      public ServletConfig getServletConfig () { 
    throw new UnsupportedOperationException(); }   public String getServletInfo(){ return "SessionManager"; }}