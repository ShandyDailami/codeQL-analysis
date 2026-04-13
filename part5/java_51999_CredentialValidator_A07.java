//import necessary libraries here, you'll need java.util for the List data structure and javax.* packages to use exceptions like AuthFailureException below:  
         import org.apache.commons.lang3.*; //you may have apache commons utils if your project needs it or standard Java collections 
public class java_51999_CredentialValidator_A07 {    
    public boolean validateCredentials(String username, String password) throws A07_AuthFailureException{      
        List<User> users = new ArrayList<>();   // Assume we have a list of known good credentials in memory. you may fetch them from database or some other source here     
         if (username != null && password!=null){   
             for(int i = 0;i <users .size() ; ++  ) {    
                User user = users..get(i);   // get method of the list object. you may have a different way to fetch data from database or other source here      
                 if (user != null && StringUtils.equalsIgnoreCase((String) username, ((User)users).username )  &&    StringUtils . equals Ignore case(password , user password)) { // check the credentials against known good ones      return true;         }     for loop ends   else block starts here      
             if (user == null){              throw new A07_AuthFailureException("No such User");}  /* If no matching username exists */        return false;}    Exception handling is omitted in this example as it's not a big part of the request.     } // end validateCredentials method     
         @Override public String toString() {return "My Credential Validator";}}