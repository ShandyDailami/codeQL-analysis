import java.io.*; // Import File I/O classes needed for file handling tasks and exceptions    
        import javafx.util.Pair;   /* For the Pair class */ 
        
public class java_51947_FileScanner_A01 {     
    public static void main(String[] args) throws IOException{            
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); //Create a buffering character input stream and an outputstream to read user inputs from the console,  so as not to expose any sensitive information in our program        
           System.out.println("Enter Directory Path: ");            
            String dir = br.readLine();// Reads string entered by users         
               File folder =  new File(dir);     // Create a file object using directory name provided   getFiles and listFiles methods of files are used to access the specified pathname/directory or return an array containing directories in the given directory   
           if (folder.exists()){             System.out.println("Directory exists");              Pair<String, Integer> res =  new  javafx.util.Pair<>( "Exists", folder.listFiles().length);         // Returns a pair with first element - whether file or dir and second as the count of files/dirs in directory            
           } else {                           System.out.println("Directory does not exist");     return;    }} catch (Exception e) {}  /* Catch any exception that may occur */     
        `} // closing curly bracket for Main class   }; It'll always execute until the execution reaches this point, and then it will end with `return;} } ' - EOF. This is how we can terminate our program in Java as per instructions given above by removing comments (/*...*/)