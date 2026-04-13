import java.io.*; // Import Java I/O classes (like File, DirectoryStream etc.)  
// Also import other necessary libraries like BufferedReader and PrintWriter if needed based on your project's requirements        
public class java_44129_FileScanner_A07 {      
    private static final String INPUT_FILE = "./test.txt"; // the file to scan          
     public static void main(String[] args) throws Exception{ 
        File inputDir= new File (INPUT_FILE);         
            if (!inputDir.exists()) throw new IllegalArgumentException("Input directory does not exist");   
                try (BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream(inputDir)))){           // use a buffering Reader for performance improvement 
                    String line;         
                   while ((line=reader.readLine()) != null){               if ("authFailure".equalsIgnoreCase (line) ){                       System.out.println("Auth Failure detected: "+ line);                      }                  // use equals method because it's case insensitive                 else {System . out . println(“ignoring non-login attempts” );}}              
                catch  (IOException e){throw new IllegalStateException ("Cannot read file",e) ;}}}             finally{ System.out.println("Scanning done.");}          }   // use try/catch to ensure any exception is caught and handled gracefully           if(inputDir .exists() ) { inputDir.delete();}} else 
            throw new IllegalArgumentException ("Input directory not readable: " + INPUT_FILE);    }}// close of the main method             public class AuthFileScanner          // define a static nested authfile scanneer (class) for your program’s authenticationfailure purpose if needed. }`!