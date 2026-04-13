import java.io.*;  // Import Input/Output Streams and related classes
class java_52681_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        String filePath = "path_to_yourfile";         
        
            FileScanner fs= new FileScanner();            
           if (fs.canReadFileWithoutCheckingSecurityAccessRulesInJava8Style()) {             
                System.out.println("Reading the content of a text-based file without any security access rules in Java 9 style:");       
            BufferedReader br = new BufferedReader(new FileReader (filePath));    // Creates an input stream for reading characters and lines from character-input streams, buffering them internally.  
             String line;      
               while ((line=br.readLine()) !=  null){    
                    System.out.println(line);               
              }      br.close();  // Closes this stream并将其送回系统。    This method should be used after all methods in a finally block that might throw an IOException have completed normally, to close the underlying input streams and free up system resources so these calls can happen more than once unless explicitly done otherwise by some other means (such as when exiting from try-catch).
            } else {        // If we cannot read file without checking security rules then print message.     System.out.println("Can't access the specified location, maybe you don’t have necessary permissions?");  }}