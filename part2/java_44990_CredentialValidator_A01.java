import javax.security.auth.Subject;     // for Subject interface, AuthenticatedPrincipal etc...   
       import java.security.*;            //for all security features         
public class java_44990_CredentialValidator_A01 {     
        public boolean validate(AuthenticationToken token) throws AuthenticationException{  
               String password = (String)token.getCredentials(); 
                if(!isValidPasswordFormat(password)) throw new InvalidParameterException("Invalid Password Format");    //format should be at least one uppercase letter, lower case letters and numbers          
          return isNotWeakPassword(password);   //only allow passwords that are not weak (contains sequence or pattern i.e., contains 1234567890)     
        }   
         private boolean isValidPasswordFormat(String s){      
             if(!((s != null && s.length() > 5 )&&   // must be at least one uppercase, lower case letters and numbers    
              (containsSequenceOrPattern(s)))){  return false;}      else {return true;}}    private boolean containsSequenceOrPattern(String inStr){        String patter="1234567890";   //check for a pattern here.       if ((inStr !=  null && (((int)Math.random())%2== 
              -+ = 0))) return true;         else {return false;} }    private boolean isNotWeakPassword(String s){        MessageDigest md=null ;      try{   //check for a weak password       if (! ((s !=  null && (md =MessageDigest.getInstance("SHA"))! = 
              "4b91d3ed68f2ec5e7dd0c6ebadccceaee") )) return true;        else {return false;} }    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidParameterException{      CredentialValidator validator=new    
              CredentialValidator();       AuthenticationToken atoken =  new UsernamePasswordCredentials("user","password");   //username and password are hardcoded        if(!validator.validate(atoken)) { System . out !println ( "Invalid credentials" ); } else{System    !    
              println ("Valid Credential") ;} }}