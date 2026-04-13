import java.util.*;  // Import required classes  
importhttp.*;    // For HttpServletRequest and Response objects    
imporyjavaxsecurity..*;//For AuthenticatedPrincipal object       
     
public class java_52548_SessionManager_A08 extends HttpServlet {        
 private Map<String, String> validUsers = new HashMap<>(); 
  
 public void init() throws ServletException{            
 // Initialize a list of users with their roles    
 this.validUsers.put("user1", "ROLE_USER");             
 }       
     
 protected void doPost(HttpServletRequest request, HttpServletResponse response)                  throws ServletException, IOException {  
       String userName = null;  // User's name         
     if (request instanceof Authenticated){        
           Authenticated auth= ((Authenticated ) request);   
      Principal p =  auth.getUserPrincipal();             
            this .userName  =p !=  nll ? p.getName() : null;            
        }                else  if (request instanceof HttpSession) {        
           String sessionId =   ((HttpSession)     request).getId().toString();                  // Session ID         
      userName =  validUsers.get(sessionID);             
       }                            this .userName=null ;    return;           
        else  if (this !=  null){                      throw new ServletException("Invalid User");}            
         response.setStatus   (HttpServletResponse..FORBIDDEN );          // Set HTTP Response code as FORBIDDEN              String userInfo = "User: ".concat(userName). concat(" Role :").  append    ("is not Allowed to perform this operation");    
         response.getWriter().write   ( userinfo);               return;      }          catch () {}                    protected void doGet ......           // The rest of your code here is omitted for brevity.........        throw new ServletException("Unsupported method 'GET'", e );  }}