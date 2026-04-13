public class java_48482_CredentialValidator_A08 implements CredentialValidator {    
    // Constant arrays containing the necessary characters  
    private static final char[] REQUIRED_CHARS = {'A', 'a'};       
      
    @Override        
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException 
    {            
            String id=credentials.getIdentifier();          
               // Use the user ID to check against rules  
              if (id==null || isWeaklySecureId((char[] ) id))         return false;          else      return true ;        }     public boolean supports(Credential c)  {             return Credential.class .equals    ((ParameterizedTypeReference<?>)c).getType());  
}            private static final int REQUIRED_PASSWORD_LENGTH =2+REQUIRED_CHARS.length;       char[] password=credentials.getPassword();      if(password==null||isWeaklySecure((char [] )    password)) return false ;  else       
return true;}         private static boolean isStrongEnough (String s, int strength) {   //check for length and presence of char arrays     }       protected void checkPasswordField() throws IOException{             String fieldName = getRequest().getParameter("field");          if(isEmptyOrNullAttributeValueInSessionScope((char[] )"username", null)) throw new IllegalStateException ( "No user name attribute in request scope.");  
if(!isWeaklySecureId())     return;       } private static boolean isStrongEnoughPassword(){    //check for length and presence of char arrays         if(isEmptyOrNullAttributeValueInSessionScope((char[] )"password",null))  throw new IllegalStateException ( "No password attribute in request scope.");     
return true;}     protected void checkUsernameField() throws IOException {             String fieldName = getRequest().getParameter("field");          //check if we have a correct user name or not.         }   public boolean isWeaklySecureId(){           return false;}}    private static final int REQUIRED_PASSWORD_LENGTH = 2 +REQUIRED_CHARS .length ; 
char[] password = ( char [] ) getRequest().getParameter ("password");     if(isStrongEnoughPassword() && isWeaklySecure()) return true;    else       throw new IllegalStateException("Not strong enough or secure."); }   public boolean supports(Credential c) {        
return Credential.class .equals (c); }}  SecurityQuestionServlet:     class SecuredWebEJB extends WebEJB implements EJBAccess, InitialListener {} @PreDestroy protected void preDestroy() throws IOException{ getRequest().getSessionContext(true).invalidate(); }