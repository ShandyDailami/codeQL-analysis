import java.io.*; // Import necessary classes 
  
public class java_51757_FileScanner_A08 {    
    public static void main(String args[]){       
         try{            
            File file = new File("C:/Users/Public");          
                 if (file.canRead())                     
                     System.out.println("\nReading from a directory: " +   // Reading files in Java 10x style                      
                             Files.readAllLines(Paths.get('./src'+ file .getName())));        
             else                                           
                 throw new SecurityException("Cannot read the specified location");             
                  }                                  catch (SecurityException se){                    System.out.println("\nCaught exception: " +   // Error handling in Java 10x style                    
                             Severe(se));                   return;                       }}                           finally {printFooter();}}           private static void printHeader(){System. out .println ("\t"+ "\u2639 \u25A0 File Scanner Program :");}   // Unicode for a star          private 
static    void     printFooter()        { System..out...printf("End of program.");}}         public static       boolean Severe(SecurityException se){printHeader();      return false;}             } catch (IOException e)                {}                 system. out .println (" \n Exception: " +   // Handling I/O exceptions
     error); printFooter; }}                      `catch' block to handle the file operations and 'finally' clause for clean up code after execution of a program, if any exception is thrown in catch or finally blocks then this will not be executed. In our example "return" statement at end would mean that no further steps should happen when an error occurs during processing - it stops executing here as per Java standards and hence can help to prevent memory leaks caused by such cases too!