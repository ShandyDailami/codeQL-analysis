import java.util.*;   //For Scanner class java_51254_CredentialValidator_A03 ArrayList collection framework   
class Main {    
      static boolean isValidUsername(String input)  {          
          List<String> validUsers = Arrays.asList("user1", "admin");             
         return (validUsers.contains(input));       }   //Check if username exists in the list of allowed usernames    
    public static void main (String[] args) throws java.lang.Exception { 
        Scanner sc=new Scanner(System.in);                  
      System.out.println("Enter your user name: ");           String inputUserName =sc .nextLine();          if (!isValidUsername(inputUserName))         //Checking username against the list of allowed usernames    {              println ("Invalid credentials");     return;   }       else 
      System.out.println("Welcome "+inputUserName);        }}`  `