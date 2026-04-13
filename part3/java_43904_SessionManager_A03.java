import javax.security.auth.Subject;   // Import Subject from JAVAX SECURITY AUTH package    
    import java.util.*;               //Import utilities (ArrayList, HashMap) needed by SecurityManager class java_43904_SessionManager_A03 the subject object created below
public final class SessionSecurity {  //Create a public static session manager for security sensitive operations that involve injection attacks like this  
// Private Instance variables are used to store data related securely.    They can be any type of variable as long it is safe from an A03_Injection attack if you use the right methods here        
private final List<String> sessionData = new ArrayList<>();  //Session Data for Security Sensitive Operations that involve injection attacks  
// Private Instance variables to store subject and principal information needed by security manager.    They can be any type of variable as long it is safe from an A03
 private Subject currentSubject;      
private Object principal;            
  // The SessionSecurity class only contains methods for the purpose this example, all other method will throw UnsupportedOperationException  
 public void beginSession(final String userName) {    try{     if (userName == null){throw new IllegalArgumentException("Null username is not allowed.");}      currentSubject = Subject.getCurrentSubject();       principal=currentSubject.getPrincipal();  sessionData .add ("Starting a Session for : " +principal); }catch(final Exception e) {     //Handle exceptions that occur during the transaction here  
e . printStackTrace ();}}    public void endSession() throws IllegalStateException{try{} catch({IllegalStateException ise){throw new  Illegaltatexception("session not active");}})      if(currentSubject == Subject.getCurrentsubject()) { throw new UnsupportedOperationExceptioMN ("Can't close the session - No Session Currently Active") }     current subject = null; principal=null;}