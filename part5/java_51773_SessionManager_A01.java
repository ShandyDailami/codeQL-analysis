// import required libraries/classes and interfaces
import java.util.*;   // List, Iterator etc...

public interface User {    /* Define an empty Interface */ } 
public class java_51773_SessionManager_A01 implements User {}     /* Defining the simple implementation of a user for this example*/      
       
interface SessionManagerInterface{      /**/}        
class AccessControlSessionValidatorExample   extends ArrayList<String> implements Iterable<Object[]>  {    public boolean validate(final Object o){  return true;}} // Default Validator returns always valid.     /* Defining the default access control mechanism*/       
public class SessionManagerLegacyStyleImpl1234567890 extends AccessControlSessionValidatorExample implements InterfaceForTesting, AnotherInterface {   public static void main(String[] args){    SimpleUser s = new SimpleUser();      // Uses our implementation to validate sessions here.     System.out.println("Is session valid? " + ((AccessControlSessionValidatorExample)s).validate((Object)"123"));  }