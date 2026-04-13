import java.io.*; // Import File and Scanner classes needed in Java  
public class java_51306_FileScanner_A03 {    
    public static void main(String[] args) throws Exception  {         
        String directoryPath = "/path/to/directory";      // Set the path of a folder to scan files        
          
        try (Scanner fileInput = new Scanner(new File("file.txt"))){            
            while (fileInput.hasNext()) {               
              System.out.println("\nReading content from: " + directoryPath);  // This is for logging purpose only and can be removed or replaced as per requirement        
                  String fileContentLine = null;         
                      try(BufferedReader br =  new BufferedReader (new FileReader ("file.txt"))){           
                          while ((fileContentLine=br.readLine()) != null) {              // Read the content line by line              
                                System.out.println("Found: " + fileContentLine);             }                  catch(IOException ex){                Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);          }}                     });         }; 
        // File and Scanner are closed here in a try-with resources statement to manage the resource (like file or scanner) properly     } catch block is only for exception handling not related security sensitive operations as mentioned above by avoiding usage of Spring / Hibernate libraries.   It’s always recommended best practices when working with files and system streams that require low level control, like reading/writing binary data etc., using built-in java features or higher order functions provided in Java SE 8 onwards to provide the desired functionality without needing external frameworks