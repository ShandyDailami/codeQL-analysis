import java.io.*; // Importing standard classes from Java framework for file handling (like File, Directory) and I/O exceptions   
class java_52554_FileScanner_A01 {    
      public static void main(String[] args){        
        String directoryPath = "C:/";          
          walkDirectoryTree(new File(directoryPath));            
       }           
   // Recursive function to list files in a given folder (and subfolders)    private and static    
      public static void walkDirectoryTree(File root){         if(!root.exists() || !root.isDirectory()) {           System.out.println("Not an existing directory: " + root); return;       }             File[] files = root.listFiles();               for (int i = 0; i < Math.min(files.length, 15); ++i)  
      // Security-sensitive operations related to A01_BrokenAccessControl here    if (!new FilePermission("file:" +       file[i].getAbsolutePath()).implies("read")) continue ;               System.out.println(files[i]);           }     for (File child : root.listFiles()) { // recursive call to each sub-directory         walkDirectoryTree((child));   }}