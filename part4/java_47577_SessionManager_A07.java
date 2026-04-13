import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;  
public class java_47577_SessionManager_A07 extends HttpServlet {   
      public void doPost(HttpServletRequest request,    
                         HttpServletResponse response) throws ServletException, IOException{      
        //Create session object: 
          HttpSession session = request.getSession();        
           if (session == null){            
              System.out.println("No existing Session");      }                else {              
            String nameVal=request.getParameter("name1234567890_abcdeeooppqrstuvxyzABCDEOOPPQRSTUVXYZ-._+cpefhiogqtukwel");  //Getting session ID           
               if(session.isNew()){            
                  System.out.println("Session created: " + nameVal);                }              else {  
                 String existingValue = (String)session.getAttribute("name1234567890_abcdeeooppqrstuvxyzABCDEOOPPQRSTUVXYZ-._+cpefhiogqtukwel");  //Getting session attribute's value            
                 if(!existingValue.equals(nameVal)){              System.out.println("Session not matching with the expected name, or it already expired.");          }                else{       
                  String newName="New Name";  
                   request.setAttribute("new_attr","This is a test of setting and retrieving session attribute");            //Setting Session Attribute 
                    System.out.println(request.getAttribute("new_attr"));             response .addHeader ("Cache-Control", "no-cache, no-store, must-revalidate ");    }                return;}               };          }}`   This is a very minimalist and not recommended way of doing things in real world projects due to lack of security measures.