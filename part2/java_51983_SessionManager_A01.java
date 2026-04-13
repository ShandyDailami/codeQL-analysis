import javax.security.auth.*;
public class java_51983_SessionManager_A01 {   //Secured Access Control Mechanism example, replace with actual implementation of secure access control mechanism you have in place (like JAAS or Spring Security)   
     private String userName;      //User name for authentication and authorization checking 
      
        public boolean authenticate(String username , char[] password){          
            try {                
                new Authenticator().login(username,new String(password));  
          }catch (NotAuthorizedException e1) {              
              return false;     //Unauthorised access. 
         } catch (AuthenticationFailedException e2 ){   
             return false;      //Couldn't authenticate with the provided credentials                
        }          
            userName = username ;       //Assigning successful login to 'userInfo'.  
          System.out.println("Welcome " + userName);    
         return true;}             
    public void sessionInquiry(){      ///Session Inquiries related operations 
             if(isUserLoggedin()){              
                 //Here you can perform some operation about logged in User's Session               
                  System.out.println("Successfully Loged-IN, Welcome " + userName);              }else{                     
                     throw new SecurityException ("No active session");}}         public boolean isUserLoggedin(){        ///Checking if a client has an open connection or not          return (userName != null) ? true : false;      }}`  // End of Secured Access Control Mechanism example    }