public class java_44605_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        if ((args = java.security.Security.getProperties()).containsKey("java.home"))  // A03_Injection check step I (i) - command-line arguments injection by user input, here we are just checking the presence of "java.home" key in Security properties to ensure that our program is running with appropriate security context
        {                
            System.out.println("Security Properties:");            
            for(String name : (Iterable<String>) java.security.Security.getProperties().keySet())  // A03_Injection check step II - extract keys from Security properties, here we are just printing the key set to ensure that our program is running with appropriate security context   
                System.out.println(name);            
        }        
                
        java.util.Scanner in = new java.util.Scanner (System.in) ;   // A03_Injection check step III - reading input from user using Scanner, here we are just taking console as an additional source of data for parsing    
            
           System.out.print("Please enter your XML: ");        
        String xml = in .nextLine()  ;   // A03_Injection check step IV - reading and storing user input into variable, here we are just taking console as an additional source of data for parsing    
            
           parseXml(xml)       ;    // Parse XML using the parser        
        }         
}