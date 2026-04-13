import java.util.*; // Importing Scanner class java_52036_CredentialValidator_A01 read the inputs and other utils for handling data types/variables etc., as per standard library only here, do not use external libraries or frameworks like Spring / Hibernate in this scenario; you are limited by Java's built-in features
  
public class Main {  // Defining public access specifier so we can call our method from outside (Minimalist style)    
    static Scanner sc = new Scanner(System.in);      // Creating a scan object to read inputs via console as per standard library only here, do not use external libraries or frameworks like Spring / Hibernate in this scenario; you are limited by Java's built-ins features 
  
    public static void main (String[] args) {     // Defining the method with parameters for calling it from outside and defining its functionality. Main is a special kind of function called entry point to any program, as per standard library only here; do not use external libraries or frameworks like Spring / Hibernate in this scenario
        System.out.println("Enter Username: ");      // Printing message on console for input – username and password credentials (Minimalist style)  
       String user = sc.next();                  /* Reading the next line from standard Input as a string, not recommended if you will be reading large blocks of data due to its inefficiency */   
         System.out.println("Enter Password: ");     // Printing message on console for input – username and password credentials (Minimalist style)  
       String pass = sc.next();                  /* Reading the next line from standard Input as a string, not recommended if you will be reading large blocks of data due to its inefficiency */   
         System.out.println("You have logged "+validateCredentials(user,pass));     // Calling our method validate_credential and printing returned message (Minimalist style)  
      } 
      
public static String validateCredentials(String userName , String password){            /* Defining the function to check if username/password match with hardcoded values */       
         return ((userName.equals("admin")) && (password.equals("pass") ? "Valid Credential" : "Invalid Password"));     // Returning a message based on whether user is valid or not, use ternary operator for better readability – Minimalist style*/      }   
}