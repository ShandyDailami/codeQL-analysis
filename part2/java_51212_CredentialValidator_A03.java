import javafx.util.Pair; // for Pair object to represent user input pair - username, password  
                         // which can then be used in the validator function   
    
public class java_51212_CredentialValidator_A03 {     
        public static boolean validate(String enteredPassword)  {          
            if (enteredPassword == null || enteredPassword.length() < 8){            
                return false;         }      
          //Check for uppercase and lower case letters, numbers    -  
               Pair<Boolean, Boolean> strong = new Pair<>(false , true);       
           boolean hasUpperCase=false ;  int i = 0;     
            while (i < enteredPassword.length() && !hasUpperCase){             if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains("" +enteredPassword.charAt(i)) ){               hasUpperCase = true ; }     i++;             
            //Check for specific characters -   '?' and '#'   
                if (!"?#$%&*@~".contains(""+ enteredPassword.charAt(i))) {  strong= new Pair<>((strong.getKey() && hasUpperCase) , false);}      return !enteredPassword .equals ("")&& ((hasUpperCase || i >=7 )|| "?#$%&*@~".contains(""+ enteredPassword.charAt(i))) ; }   
          //return whether the password is strong or not   -        if its weak then false else true     return (strong .getKey() && !enteredPassword  .equals ("") || (!hasUpperCase ||  i < 8 )|| "?#$%&*@~".contains(""+ enteredPassword.charAt(i)));
    }      public static void main(){         String password = "";       // Test the function with some sample credentials          System.out .println (validate ("ABCDEFG123!") ?  "Strong Password":"Weak or Invalid PassWord");}   }}`;