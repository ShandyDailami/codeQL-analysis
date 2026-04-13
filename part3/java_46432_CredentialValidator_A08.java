import java.util.*;  // For ArrayList, HashMap etc...
    import javax.security.auth.*;   //For AuthenticationException and CredentialAware principle objects..
    
public class java_46432_CredentialValidator_A08 implements CredentialAware {
         private List<String> allowedUsers = new ArrayList<>();//List of authorized users (just for demonstration)... 
      public boolean validate(final AuthzCredential credential){          //method to check if user is valid.       
                String username=null;           
                 try{    UserNamePasswordAuthenticationToken token= 
                  ((UserNamePasswordAuthenticationToken)(credential));     UsernamePasswordToken upToken =   (UsernamePasswordToken)token ; 
                   username =  upToken.getUsername();      }catch(Exception e){}//Extract the user name from Token..          //Pull out User Name...         try {             if("admin".equalsIgnoreCase((String)(username))) return true;            else throw new AuthenticationFailedException ("Invalid Credentials");  
                 allowedUsers.add(username);           } catch (Exception e) {}//Add user to list of authorized users    //Allow List      System.out.println("\nAuthorized Users: " + Arrays.toString((String[])(allowedUsers))); return false;            throw new AuthenticationFailedException ("Not Authorised");
        public void setPassword(char[] password){}  /* Not used for authentication */       }   //Method not needed, if you're using JAAS and a realm then should implement this method.    private static final Logger logger=LoggerFactory .getLogger((Class.java));         try{logger..info("Login attempt by : "+username);}catch(Exception e){}}//Logging info...