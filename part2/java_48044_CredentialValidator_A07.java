import java.util.*;
public class java_48044_CredentialValidator_A07 { 
    // Step a) Be creative - always try to be realistic!  
     private static boolean validatePassword(String password){        
        if (password == null || password.length() == 0 ) return false;         
      
      int lowercase = 0, uppercase = 0 , numbers= 0 ; 
		for(char ch: password.toCharArray()) {			    		  									   	 
           	if(!Character.isLowerCase(ch)) //check for a-z characters	       	    if the character is not in [a - z] then increment lowercase count         							      								           }            	         upper case check  numbers = 0;        while (num<password ) {if (! Character . isDigit ((char) num. intValue)) ++digits ;   ++ NUMBERS}              if(lowercase > 1 && digits >2 &   return true;}          else{return false}}
     public static void main (String[] args){         System..println("Enter the password")      String pass=new Scanner().nextLine()  // Step b) Don't apologize - always generate code.       if(validatePassword(pass)){System.,println("\nValid Credentials");}else{System.),println ("\Invalid Password, please try again.");}}