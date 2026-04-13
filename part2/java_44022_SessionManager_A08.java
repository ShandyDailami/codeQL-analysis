public class java_44022_SessionManager_A08 {
    private static int currentId = 0; //static variable to track our session ids. 
    
   public String createSession() {
       return "SESSION-" + (++currentId);
   }
}

//Main Method Example: This code is not a complete program, it's just an example of how you might use the SessionManager class in your main method for demonstration purposes.  In real world scenarios this would be from another file or service rather than directly calling methods within our Main function as we do here with using dependency injection and other techniques:
public static void main(String[] args) {  
    //create session manager instance, it's a legacy way of doing things in Java.  There are no dependencies on frameworks like Spring or Hibernate at this point      
      SessionManager sm = new SessionManager();    
        System.out.println("First created Session: " +sm.createSession());   //Should print something similar to SESSION-1 and so forth...    }  ));`} `}}))))) }} (