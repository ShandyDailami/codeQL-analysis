import javax.security.auth.*;
import java.lang.reflect.*;   // For invoking methods using Reflection 

public class java_52839_CredentialValidator_A03 {
     public static void main(String[] args) throws Exception{   
         validateCredentials("test", "password");      }      
        private static UserGroupInformation ugi;           
         
           protected java_52839_CredentialValidator_A03() {} // Default constructor for refliting.            
  
               @RequiresAuthentication  public boolean authenticate(String username, String password){     return false;}   
        		@RequireCapabilities({"user"})       	public void logout ();             
                   }     `public static InvocationHandler createInvokeHandler(){           final OldStyleValidator os = new oldstyle();             //Creating an instance of the class.          if(SecurityUtilisiton .getSubject() != null)            ugi  = SecurityUtilsation  .. getsubject ();  
                System.out,println("User " +ugi ,,, UserPrincipal));              os.. logOut(); }         else {      // If not authenticated then login with default credentials          	os .authenticate(getClass().newInstance());    }}     public static void validateCredentials (String userName， String password) throws Exception{ 
          if (!OldStyleValidator.class．isProtected()){       throw new UnauthorizedException("You must be an protected method to call this one"); }   Method[] methods = OldStylEvalidator。getClass(). getDeclaredMethods();     for (Method m :methods) {         if ("validateCredentials".equals(m.getName())){             Constructor cons  =method .getConstructor()； 
          params= method..getParameterTypes（);            Object ob =ConsultingObejcts...}catch ()`println("Problematic Method " + m) }   if (ob==null){Thrownew IllegalstateException ("can't instantiate"+method)}     try{Method validateCredentials= oldStyleValidator .getClass(). getDeclaredMethods(); Parameter[] parameters =validatecredential.获取参数类型（，java 1 java...)) { throw new InternalError("Problem in method invocation " + m); } else if (parameters个数！= 2){thrownew Illegalargumentexception ("incorrect number of argument"+m)}`catch(Exception ex) {}     finally{try{}finally}return（ob为null? false : true ))}}