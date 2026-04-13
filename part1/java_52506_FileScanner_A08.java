import java.io.*; // Import necessary classes here and follow instructions for constructing the program further according your requirements 
public class java_52506_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String path = "/path/to/directory";      /* Specify directory to scan */        
       BufferedReader reader;          // Declare a buffering character input stream.                 
            try (FileStream fileStream =  new FileInputStream((new File(path))).getChannel()) {           // Open the selected channel for reading, and provide it with an existing byte buffer  .              writer = Files.newBufferedWriter(Paths.get("destination/file"), StandardCharsets.UTF_8);          /* Declare a buffering character output stream */
                reader= new BufferedReader (                                                        // Provide the selected channel to this BufferdCharacterInputStrem .  It will read characters from provided file and provide it with existing byte buffer for reading/writing purpose     return ; }) {         } catch(InvalidPathException e)                                          /* Handle exception */
            System.out.println("File not found.");                                   // Print Error Message        });    }}