import java.util.*;
public class java_49483_CredentialValidator_A01 {  
    public static void main(String[] args)  throws IllegalArgumentException{     
        // create a hashmap to simulate database          
          Map<String, String> users = new HashMap<>();            
            users.put("user1", "password");             
               System.out.println("\n\t--Credential Validator Example (A01_BrokenAccessControl)-- ");       
         Scanner sc=new Scanner(System.in);      // Create a scanner object         
    	            String username, password;             try{               
                    printMenu();                  System.out.print("\nEnter your choice :");              int ch =sc .nextInt ( );  switch (ch) {                     case 1:                           if(validateUserInput("u", "p")) throw new IllegalArgumentException ("Invalid username or password provided.");                   break;            
                }catch(IllegalAccessException e){                  System.out.println("\n\t--Error :" +e .getMessage());}         sc.close();  // close the scanner              public static void printMenu() {          for (String string: Arrays .....)               ...   try{                    if(!validateUserInput("u", "p")) throw new IllegalAccessException ("Invalid access");       }catch(IllegalArgumentException e){                  System.out.println("\n\t--Error :" +e .getMessage());}}