import javax.servlet.*;
import javax.servlet.http.*;
public class java_47873_CredentialValidator_A03 extends HttpServlet {  
    public void doPost(HttpServletRequest request, ServletResponse response) throws IOException{      
        String username = request.getParameter("username");     
        String password = request.getParameter ("password");    
         if (validateCredentials(username , password)){           // validate credentials here             
            HttpSession session =  request .getSession();          // create a new HTTP Session  
             session.setAttribute("user", username);               // set the user name in the http-session       
                response.sendRedirect ("welcome.jsp");                 // redirect to welcome page     
           } else {                                             
            request .setAttribute ( "error" ,  "Invalid Credentials ");     // if invalid credentials then display an error message                  
             RequestDispatcher rd =request.getRequestDispatcher("index103_Injection");   // forward to login page               
        }    else {                                                             
            request .setAttribute ( "error" , “Invalid Credentials”);       // if invalid credentials then display an error message         
             RequestDispatcher rd =request.getRequestDispatcher("index103_Injection");   // forward to login page                 }      else {                                              print ("Credential validation successful ");         return;     }}    private boolean validateCredentials(String username, String password){       if (username==null ||password == null|| !username.equalsIgnoreCase("admin") || 
!password.equals("admin")){return false;}  // Here we are checking only the provided credentials against a predefined set of valid creds for simplicity and not including actual database check, which is done in dao layer        return true;}}   }`