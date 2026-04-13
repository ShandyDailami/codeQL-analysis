import java.io.*; // For File I/O classes, see below: BufferedReader, PrintWriter etc...   
public class java_52730_FileScanner_A07 {  
 public static void main(String[] args) throws IOException{      
     String directory = "/path_to_directory";  /* Add your path to a valid folder here */        
      File f= new File(directory);        // Get file or directory.         
    if (f.isDirectory()){           /** Check whether given path is a directory **/             
       String[] list = f.list();     ** List all files and directories in that directory**                
       for (String name : list) {   /* Iterate through the names of each file/directory */           
         File nf = new File(f,name);  // Create a new instance to get full path       
           if (!nf.isHidden()) {}    /** Check whether current item is hidden (i.e., .DS_Store on Mac)***/                 
              {       System.out.println("File: " + nf.getName()+" in directory :  "+ f);     // Print name of each file        }               
            if (!nf.isDirectory()) {}    /** Check whether current item is a regular (non-directory) File **/                 
              {       try(BufferedReader br = new BufferedReader   // Try reading and printing the contents      */            
                      (new FileReader     /* Using this constructor with nf for file operations.  This will read our files **/                  
                       ) );         System.out.println("--------------------");        /** Printing a separator **/                  }    }}}}}}}** End of SecureFileScanner code snippet */