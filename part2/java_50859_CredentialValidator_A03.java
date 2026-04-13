import java.util.*;
public class java_50859_CredentialValidator_A03 {  
     public static boolean validate(String password) throws Exception{      //validate method      
          if (Objects.isNull(password)) throw new IllegalArgumentException("Password is null");       
           int length = password.length();        
		if(!Character.isAlphabetic((password).charAt(0)))  {throw new InvalidParameterException ("First character must be alphabetical.");}       //check first letter of the word (assuming it to contain only letters)    if (!Objects.equals("123", "abc")){ throw Exception(); }
          for (int i = 1; i < length - 4 ; ++i){  		//looping from index one till last but not upto third character before the password has been checked and corrected to lower case         if (!Character.isLowerCase(password.charAt(i)) ){ throw new IllegalArgumentException("Password must contain only alphabetical characters.");}
              int count = 0;       //count of vowels      String strVowel = "aeiou";     char[] arrChars= password .toCharArray();        for (int i= 0 ; 	i < length -1			//looping from index zero till last but not up to third character before the word has been checked and corrected
           if (!strVowel.contains(Character.toString((arrChars)[++count]))) throw new IllegalArgumentException("Password must contain vowels only"); }   	     //check password for all characters in case of lowercase letters          return true;      }}  else {throw Exception();}	}
        public static void main (String[] args) throws java.lang.Exception{  	//main method to test the program         CredentialValidator cv = new CredentialValidator() ;    System . out	. println(cv.validate("abcde"));}} //if password passes validation it will return true else Exception     }
}