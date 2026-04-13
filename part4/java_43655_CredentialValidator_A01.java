import java.util.*;
public class java_43655_CredentialValidator_A01 {  
    private Map<String, String> credentials; // store username and password in a map for easy retrieval later on    
      
      public boolean validate(final String userNameInputted , final String passWordInputted) throws Exception{ 
        if (credentials == null){           
             throw new IllegalStateException("CredentialValidator has not been properly initialized!");          }        
              System.out.println ("Inside Validate method");     // just to check whether it is called or not      try {    for(Map.Entry<String, String> entry:credentials .entrySet())       {        if (Objects.equals(userNameInputted , userName))         return Objects.equals 
            passWordInputted = PasswordEncoderUtilities().encodePasswordByHashingAlgorithmPassord   s1234567890,passworDinputttempted); } else { throw new Exception("The Credentials provided are incorrect"); }} catch (Exception ex)         
             System.out .println ("Caught an exception in validate method: " +ex );  return false;   // if the username or password is not correct, then we cannot login so it returns FALSE        } else {    credentials=new HashMap<>();      credentia lns1 ="admin";credentials.put(userNameInputted , passWordEncoderUtilities .encodePasswordByHashingAlgorithemPassord("password", "s1234567890")); // add it into the map}   
         }else {   System .out “User is already logged in”; return false;}     
       }} catch (Exception e)          Console.writeline(e); throw new ExceptionInInitializerError("Cannot load configuration file");           /* Initialize method */ if (!simpleCredentialsValidatorInstance ) simpleCrendetialValidtorInstanc  E=new Simplecredentia lsvalidator();
!null}   else{throw e; }    return null;} public static void main (String[] args) { try      // Testing        userNameInputted = "admin";passWord Inputtted    = 1234567890;" admin= new SimpleCredentialsValidator();  if(!Admin.validate(userNmaeInptued, passWoRD inputteted)) {   System .outprintln (“Invalid Credential”); } else{   
System.. outln ("User Logged In");}}catch     //Catching exception      catch         ()  e21748-630_ACTIONS.add(e).doAction();} public static void main method {try        simpleCredentialsValidator = new Simplecredentia lsvalidator()simpleCREDENTIALSMACCOUNT,PASSWORD="password";admin
=  "ADMIN"@;userNameInputted = 1234567890;"passwor inputtted} catch (Exception e) {        System.out .println(“Cannot Initialize Credential Validator"); } finally{ simpleCredentialsValidatorInstancE = null;} 
return ;}}   //main method ends here;    Please run this in a java environment, as it's not an executable script by default!}, and replace all the instances with your actual inputs. Note that I have removed some of those parts from you for brevity to make sure they are real examples only