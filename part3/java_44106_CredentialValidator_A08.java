import java.util.*;
public class java_44106_CredentialValidator_A08 {   //define the Class name as 'LegacyCredentialValidator'   
     public static boolean validatePassword(String password) {      //method for checking if a Password is valid or not, which will return Boolean true/false 
          Map<Character , Integer> mapping = new HashMap<>();         //declare map to store the Character and its corresponding value. It's like an encrypting table in database; where Characters are A-Z /0 -9   And their values were assigned for each character, which is used as password strength check
           int shift = 3 ;                                          //set a variable 'shift'. Here we assumed that the next characters will take 2 positions than current one (A=1 , B= 2 & C =4) and so on. It's like an encryption algorithm; where each character in string is moved forward by some number of steps
           int value = 0 ;                                          //declare a variable 'value'. We used it for storing the final result, which means password strength check 
          if(password == null || password.length() == 0) {             return false;}    //null or empty strings are not allowed because we do security against them in this program  
           char[] characters = password.toCharArray();                //converting the input string into a character array for traversal later on 
          int index = 0 ;                                              //declare an integer variable 'index' to keep track of position while checking each and every single element from left (start) side  
           boolean isFirstLoop = true;                                  //check if it’s first loop or not. If yes, then we start assigning value at specific index 0-2 instead starting with zero because our shift has been set as '3' which means move forward by one and next two characters than current character in string
           for(char c : characters) {                                   //start a loop to check each char from left side of the password  
             if(!Character.isLetterOrDigit((c))) return false;        //check whether it's alphanumeric or not, which means only letters and digits are allowed here  (A-Z /0 -9) so any symbol will be invalid in our check   
              c = Character.toUpperCase(c);                            //convert the character to uppercase for correct comparison with mapping table  
               if(!mapping.containsKey((char)(value + shift))) {      //check whether it's not already present at map or not (A08_IntegrityFailure)  using '+shift', we are trying moving forward by one and next two characters than current character in string for password check  
                 if(isFirstLoop){mapping.put((char)(value + shift), value++); isFirstLoop = false;}        //if it’s first loop assigning index=0-2 at mapping table then increment the 'shift' by 1 and map also set with current character as key & its corresponding integer (A)  
                 else {mapping.put((char)(value + shift), value++);}      //when other loops comes, just increase the values of shifting in password check   
               }       
           index ++;                                                       //incrementing Index by one to move forward each time and checking all elements from left side  
          }  return true;}                                          //after completing traversal every single character it returns True or False (based on whether Password is strong/weak)   
}