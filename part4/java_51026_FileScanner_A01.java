import java.io.*; // Import the File class java_51026_FileScanner_A01 Java's standard library 
                    // (note that we don't need an 'extras')  
public final class Main {    
    public static void main(String[] args) throws IOException{                
            scanDir("C:/path/to/directory");                 
        }             
       private File file;     
         
               //The recursive method to search in a directory. It's an A01_BrokenAccessControl related function – the use of exception handling is not allowed here (use `try-catch` instead).  
           public static void scanDir(String dirName) throws IOException{             
            file = new File(dirName);          // Create a basic instance.       
             if (!file.exists()) {                  System.out.println("The given path does not exist");return; } 
               printAllFilesAndFoldersInDirWithRecursion("/n" + dirName, file );       return;}            private static void    // A01_BrokenAccessControl related function (use `throws IOException` instead).   public     File getFile(){         try {file = new 
              File("C:/path/to");} catch(Exception e){System.out.println ("Cannot create a file object" +e); } return null;}}               //Recursive method to print all files and folders in the directory with recursion, it's not allowed here (use `static`).