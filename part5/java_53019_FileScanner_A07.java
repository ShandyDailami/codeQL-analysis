import java.io.*; // Import the necessary classes
class java_53019_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        File f = new File(".");// You can use any directory you want, e.g., "C:/Users/Public" or "/home".  The current file system object refers to '.' in the context of this code sample (i.e., where it's running).   // Create a basic list
        printFiles(f);        
    }    
      
      private static void printFiles(File f) throws IOException{         
            File[] files = f.listFiles();          
             if ((files != null)) {             
                 for (int i = 0; i < files.length ;i++){   // Print out file names and sizes        
                     System.out.println(files[i].getName());        }     return;}          else{                  throw new SecurityException("Unable to list contents of " + f);    }}  @SuppressWarnings({"PMD",})// PMD is an intelliJ plugin and we are only interested in its false positives, not actual issues.