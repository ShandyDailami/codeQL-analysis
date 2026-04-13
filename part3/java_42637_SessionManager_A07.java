public class java_42637_SessionManager_A07 {     // define your manager name as per Java Convention ie. Manager for session, Transaction etc..  
    private boolean isActive = true;      /// flag to check if the Session was active or not only when it throws an exception but we use this method just in case 
                                         /to change its state and then reactivate after calling a protected methods like login.         
     public void startSession() {       //define your session name as per Java Convention ie., starting new sessions are Session object creation   
        System.out.println("Starting the Manager");   /// you can write code here which will be executed when manager starts  or create a method to print something like this on console        
     }     
      
     public void endSession() {          //define your session name as per Java Convention ie., ending sessions are Session object destruction   
        System.out.println("Ending the Manager");   /// you can write code here which will be executed when manager ends or destroy a method to print something like this on console 
     }     
      
     public void login(String username, String password) throws A07_AuthFailure{    //define your protected methods as per Java Convention ie., Protected for encapsulation so call it using 'this' keyword. You can also add parameters validation etc..  
        if(!username.equals("admin") || !password.equals("123")) {  /// Checking conditions here to ensure that the user is admin with password as "123"    // you have more complexity in this part, for example a database call or encryption of data before comparison etc..
            throw new A07_AuthFailure();   --- If condition fails then it will execute and throws exception  /// This can be done by any method where we are expecting an Exception.    
        }       // Checking conditions ends here    otherwise, the code executes as per normal flow of a function      return;           ----- You might want to handle this in some way like logging etc..   -- end ---         if condition is true then it will execute and throws exception  /// This can be done by any method where we are expecting an Exception.    
        System.out.println("Login Successful");    // you have more complexity here, for example a database call or set session variables to the user etc..   -- end ---      return;         }       ----- If there is anything after this and before '--end' then it will be considered as comment in java    
}  /// End of your code