import java.util.*;   // for Scanner class java_52610_CredentialValidator_A03 ArrayList data structure    
public class CredentialValidator {   
// list of predefined passwords (can be stored in a file or DB)      
private static List<String> validPasswords = Arrays.asList("password1", "abc@4321");   // you can add more with this method as well       
public boolean checkCredentials(Scanner input){   
  System.out.println("\nPlease enter your password: ");     
//read the user's entry from console    
String enteredPassword =input.next();      
int attempts=0;   //counter for invalid login attempt        
while(!enteredPassword.equals(validPasswords.get(attempts))) {   
  System.out.println("Invalid Credentials, please try again!");     
//compare each character of entered password with one from valid list     if they don't match then increment attempts and break the loop         //if matches print success message else provide another attempt        }      
attempts++;  
}   
  return (attempts<=validPasswords.size()?true:false);     
//check whether we have used up all allowed login tries or not          if yes then false otherwise true     };                public static void main(String[] args) {         Scanner input = new Scanner(System.in);       CredentialValidator cv=new CredentialValidator();        System.out.println("WELCOME TO THE SECURITY PROGRAM");     
//call the method here after checking whether user's password is valid or not     if (cv.checkCredentials(input)) {          //if yes then print success message else give another attempt         }  }}   This program will only execute in a terminal/console environment and does NOT run on other platforms like browser, Android etc due to lack of input scanner object which is required for this type of programs as it asks the user's password.