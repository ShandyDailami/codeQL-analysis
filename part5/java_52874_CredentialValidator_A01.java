public class java_52874_CredentialValidator_A01 {  // Start of 'Main' Java Class declaration  
    public static void main(String[] args) throws Exception{      //Begins execution from here    
        CredentialValidator validator = new BasicCredentials();       //Create an instance to our custom implementation which includes basic security measures. The actual credential is hardcoded in the constructor of this class, not checked against a real database or elsewhere  
        
    System.out.println("Enter username: ");        //Ask for user input 
     Scanner scan = new Scanner(System.in);       //Scan to read from console (Standard Input)     
 String enteredUsername=scan.nextLine();          //Read the line of text and store in string variable  
    System.out.println("Enter password: ");        //Ask for user input  again but this time with hidden character due security reason           
     char[] enterPassword = scan.nextLine().toCharArray();         //Again read from console, convert to array of characters and store it in variable            
       if (validator.validate(enteredUsername ,enterPassword)) {        //Call the validation method with entered credentials 
          System.out.println("Access Granted!");           //Print access granted message   } else{         //Else print Access Denied or throw exceptions as necessary    try-catch block is not used here because we are only handling exception in case of wrong password which can't be caught by the program flow      
        System.out.println("Access Dismissed!");     }}          /* Ending 'Main' Java Class and Code */  //Ends execution from above code  
}