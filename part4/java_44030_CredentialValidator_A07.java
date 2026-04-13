import java.util.*;   // Importing ArrayList, LinkedHashSet etc from the Java Standard Library package    

public class java_44030_CredentialValidator_A07 {   

       public static boolean authenticate(String username , String password){     

           if("admin".equals(username) && "password1234567890".equals(password)){          // Hard-coded for simplicity        return true;         }else{             System.out.println ("Invalid Credentials");  else {            false;}       public class UserCredentialValidator implements CredentialValidator   

public boolean validate (String username, String password)   throws Exception      def userMap=new Hashmap<string , string>()     //create a hash map to store the users and their credentials. This is used for authentication        {user1 = new UsernamePasswordCredentials("admin" ,"password");   

hash Map . put (users, admin); }         return validate(username,, password) ? true : false; }}   public interface CredentialValidator     def class UserNamePasswdAuth implements CrendentialValiator {      //creating a crediental validtor using the above implementation      

public boolean Validate (String user, String pass){    if ("admin".equals(user) && "password1234567890" equals((pass))  return true; else false;}        }     public class mainMethod {         def CredentialValidator validator = new UserNamePasswdAuth();     

//Create a user credentials HashMap   private static Map<String, String> usersCredentials=new LinkedHashmap<>()    // create the crediental storage and add some values for testing.  try{           if (validator validate ("admin" , "password")) {println("Valid User");} else println(Invalid user) } catch{}catch block}}