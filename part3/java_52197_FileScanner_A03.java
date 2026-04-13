import java.io.*; // Import the necessary classes from Java library which includes File class, IOException etc  
public class java_52197_FileScanner_A03 {   
     public static void main(String[] args) throws Exception{      
        String filename = "/path/to/yourFile";         
         if (new File(filename).exists()){             
             Scanner scan= new Scanner(new FileReader(filename));           // Create a filereader object from the given string of your path. 
                      while (scan.hasNextLine()) {                    // Using hasnextline to ensure that it reads all content till end                 
                         String data = scan.nextLine();                 // This will get you one line at time and store in 'data' variable               
                          System.out.println(data);                   // Printing the read file contents on console for demonstration of injection attack         }                    
                      if (scan != null) {                            // Closing scanner object after use to free system resources                
                         scan.close();                                // Use `try-with-resources` statement which will automatically close Scanner once done using  
                    }} else{                                        // File not found exception handling  for security sensitive operations             } catch (Exception e) {...}               });    };