import java.io.*; // Import the necessary classes here - File, FilerException etc.
  
public class java_52289_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        String directoryPath = "/path/to/your/directory";         
          
        try (FileScanner scanner =  new SimpleFileScanner())  // Create a custom File Scanner using your implementation of the interface, here we are just providing simple example.            
        {           
                for(final Path file : scanner.scanDirectoryNonRecursively(directoryPath))          
               try (BufferedReader br = new BufferedReader(new FileReader(file.toFile())))  // Open the reader to each individual files in our directory     
                    while ((br.readLine()) != null);        }         catch (Exception e)              {          System.out.println("An error occurred: " +e ); }}            finally           {}       }) ;}};