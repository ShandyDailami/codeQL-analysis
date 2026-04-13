import java.util.*;  // Import Collection Framework  

public class java_43875_CredentialValidator_A07 {   
     List<String> usernames = Arrays.asList("user1", "admin");     
     ArrayList < String [ ] passwords =  new ArrayList < String [ ] > ();        
         
       public boolean validate(String user, String pass)  {        return  
               isValidUserNameAndPassword(user ,pass ); }    void main(final String[] args){             CredentialValidator validator=new     CredentialValidator();      System.out.println("Credentials Validation Result: "+validator .validate("admin", 123456));
}              boolean isValidUserNameAndPassword (String user,    final String password) {         if(user == null){             throw new IllegalArgumentException ("Username can't be empty!");        }          //Check for valid username.      /*Here we are using a set to check the existence of an element because in this case it is less computationally expensive than checking with list or array */           
     if(!usernames.contains(user)){             throw new IllegalArgumentException("Invalid Username!");        }          //Check for valid password length (should be at least 6 characters).       /*Here we are using a set to check the existence of an element because in this case it is less computationally expensive than checking with list or array */            if(password.length() < 6){             throw new IllegalArgumentException("Password should have minimum six digit!");        }          //Check for valid password (No special characters, numbers are required).      
      boolean flag = false;         /*Flag to check whether the username and/or Password is correct*/           if(user.equalsIgnoreCase("admin") && passwords.get(0)[1] == Integer.toString((int)password[2])){              System.out.println ("Authenticated Successfully!");             flag=true;        }       return  true;}
}            /* end of CredentialValidator class */