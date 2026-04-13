import java.io.*; // Import File I/O classes for file handling related operations like reading, writing files...etc..   
public class java_50816_FileScanner_A08 {    
 public static void main(String[] args) throws IOException{        
        String directoryPath = "/path_to_your_directory";  /* Insert your Directory Path here */      //Specify the path of Your folder       File object to work with files in a file system.   
           if (args.length == 0){             System.out.println("Please provide an argument."); return; }   // check for command line arguments          directoryPath = args[1];  /* Argument provided, use it as path */      String extensionToMatch  = "txt";     File dir = new java.io.File(directoryPath);
           if (!dir.exists()){             System.out.println("Given Directory does not exist."); return; }       // check whether directory exists or not          DirScanner dfs=new SecureDirScanner();  /* Initialize the scan object */      File[] listOfFiles = dir.listFiles(only ->           if (fileName.endsWith(".txt")){              System.out.println("File Name : " + fileName); }       //Check whether files are text or not
    }}