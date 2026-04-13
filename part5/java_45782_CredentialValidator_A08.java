import javax.security.auth.*;
public class java_45782_CredentialValidator_A08 implements CredentialValidation {  
    private Hash h;                     // instance of a hash object     
     public boolean authenticate(String arg0, String arg1) throws NotAuthorizedException{       
         return validatePassword (arg0);  }       void initialize()                 
                                                    throws IllegalParametersException{}          @Unwrap
   .method.accessible_exceptions|    protected int doCompare     (@NotNull Object a ,Object b )           {return h            // use the hash object to compare two passwords, returns an integer}        public java_45782_CredentialValidator_A08()  try{h=new Hash(); }catch(ExceptionE e) {System out.println("Error in creating instance"+e);