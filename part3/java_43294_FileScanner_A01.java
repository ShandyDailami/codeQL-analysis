import java.io.*; // Importing file handling classes  
class java_43294_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{ 
        String directoryPath = "/path/to/directory"; /* Specify your path here */;        
       File dir = new File(directoryPath);            
      if (dir.exists()) {                             // Checking whether the specified file or folder exists  
          for (File file : dir.listFiles()){           /// Iterating through all files and folders in a directory   
              String absolutePath =  file.getAbsolutePath();  /* Get full path of current File */                  
             System.out.println("Full Path: " +absolutePath);   // Printing the Full name (including folder)     }           }}