public class java_44380_SessionManager_A03 {
    private static int counter = 1; //static so that it's unique per instance of the object. No need in real world scenarios, only used here because there are no external frameworks/libraries available for security operations like this A03_Injection related to injection attacks 
   Session session = null;   
    
public void openSession() {         //method opens a new database connection and starts the transaction. No validation or error handling in real world scenarios, only used here because there are no external frameworks/libraries available for security operations like this A03_Injection related to injection attacks  .This is where SQL command could be done
    System.out.println("Session " + counter++  +" opened.");   //SQL commands can't be executed with a static reference, so I have used simple print statements in real world scenario for demonstration purposes only    
}     
public void close() {          //method closes the database connection and ends transaction  If this is an auto-commit session or if there are any pending changes that haven’t been committed yet then it will be rolled back. No validation, error handling scenarios in real world scenario for demonstration purposes only    
    System.out.println("Session " + counter++  +" closed.");   //SQL commands can't execute with a static reference as the logic is already covered by open method  no need of explicit close here again             
}        }                     //closing braces to represent class in Java syntax