import javafx.application.*;
import javax.servlet.* ;   // for Session management, part of J2EE standards (you may need to change this according your framework)   
// importing Servlets' interfaces if required by the program    
     
public class java_49754_SessionManager_A07 extends HttpServlet {  /* a simple servlet that handles requests */      
         public void service(HttpServletRequest request,   // for incoming HTTP Request       
              HttpServletResponse response ) throws IOException{   
                 String userid =request.getParameter("username");     // obtain the parameter from web page input field named 'userName'     
                  try {                                               /* begin transaction */        
                       SessionManager sm=new MySessionFactory().openSession();   /// create a session using your customised factory   
                        User userObj =sm.get(User.class,Integer.parseInt (request . getParameter("id")));  // Obtain the data from DB by id     
                         if(!userobj ==null){                               /* check whether it is not null */        
                              sm.beginTransaction();                    /// begin a transaction       
                                  userObj.setPassword(newpasswordhere) ;/// update password here with hash of new pass    ))));   // replace above line by your code for hashing the New Password    
                                           try {                          /* perform operation in this context */      
                                                sm .update (userobj);        /// persist changes to DB     	             	   	       		                             	 	     					         ) ;            } catch(Exception ex)    // if any exception occurs during update, rollback transaction 				  			                    finally{    	if(!sm.getTransaction().isActive()){       sm .getTransaction().commit();}} else {System.out.println("No User Found");}
                                      }}catch (HibernateException e1)                  // catch exceptions for hibernte operation if any exception occurs, rollback transaction    ))}))     		        }   finally{    	if(!sm .getTransaction().isActive()){       sm . getTransaction().commit();}} else {System.out.println("No User Found");}