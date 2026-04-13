import java.io.*; // Import File classes and Path class java_52582_FileScanner_A03 java.util.*; // For using List for array based structures, Iterator etc...    
public class MyFileScanner {     
       public static void main(String args[]) throws IOException{             
             String directoryPath = "/home/user";         
               File dir = new File (directoryPath);          
                if (dir.exists()){            // Checking whether the given path exists or not  
                    System.out.println("Directory Exists");        }       else {        
                         throw new Exception ("Given Directory does't exist!");}  List<String> list = new ArrayList<>();           File[] files;    
                          try{      // Try to access the file in a safe way   if(!dir.canWrite()){             System.out .println("The directory is not writable");            return;}          }       catch(SecurityException e) {              System. out . println (" Access denied : " +e);       
                         }}     try{           // Try to access the file in a safe way   if(!dir.canRead()){               Console.out.println("The directory is not readable");            return;}          }       catch(SecurityException e) {              System . out . println (" Access denied : " +e);       
                         }}     // Calling the listFiles method to get a File array of files and directories in this path    else{             Console.outprintln("Directory does not exist");            return;}          }  try               (FileFilter ff = new FileFilter() {           @Override public boolean accept(Path p)        
                         if (!p . endsWith(".txt"))      // Checking whether the file is a text or other type     then             Console.outprintln("skipping non-text files");            return true;          }               });       Files        . listFiles (ff);    }} catch           (*){              System        
                         out                   . println ("Error occurred in scanning directory" + e );}} // End of the try block to handle exception and finally clause for cleanup.