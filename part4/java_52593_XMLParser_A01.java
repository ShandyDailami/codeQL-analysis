import javafx.util.Pair;    // Import Pair from JavaFX utilities for easier handling of key-value pairs (key: element, value: depth)

public class java_52593_XMLParser_A01 {      // Class definition to encapsulate the functionality related xml parsing and access control checking 
    
   private static final String ALPHANUMERIC = "^[a-zA-Z0-9]+$";    // Regular expression for alphanumeric characters in a string. Used below as constraint on input data to validate it's safe from breaking points A01_BrokenAccessControl
 
   public static Pair<Boolean, String> isValidElementName(String name) {     // Method definition related with the access control checking (AOCP - Access out of class principle). Checking if input string contains alphanumeric characters. If yes return true and an empty message otherwise false & reason
      Boolean result = !name.matches(ALPHANUMERIC);   // Negation (!) to get the opposite condition, so it's safe from any potential access control issues 
       String errorMessage="";    // Empty string if no issue exists and a valid element name otherwise (AOCP - Access out of class principle). Assigning this message only when there is an invalid character in input.  
      return new Pair<>(result,errorMessage);     // Return true & empty error msg or false with the reason from condition if it's not alphanumeric 
    }                   
}