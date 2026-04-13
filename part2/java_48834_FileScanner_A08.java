import java.io.*; // Importing the necessary Java libraries  
public class java_48834_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{     
          String directoryPath = "/path/to/your/directory";      
          
          if (!new File(directoryPath).exists() || !((File) new File(directoryPath)).isDirectory())  // Checking whether the given path exists and is a valid Directory or not   
         {      System.out.println("Given directory does not exist, please enter correct dir");   return; }    
          if (!new File("/path/to/your").mkdir() && !((File) new  file('/path/to/your')).isDirectory()) // Creating a folder named '/' in the current Directory (where our java program is running), this should be done only once, otherwise it will cause an error.
         {     System .out.println("Failed to create directory" );   return; }      File[] files = new  File(directoryPath).listFiles(); // listing all Files in the given Directory    if (files == null)        throw new RuntimeException ("No file or dir found!");       for (File f :    
         files){ System.out .println("Name: " +f.getName()+ "\nSize:"  +   f.length()); }      //Printing out the name and size of each File in directory    }}