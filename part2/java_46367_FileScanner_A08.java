import java.io.*; // Import File I/O classes to read files from disk 
public class java_46367_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path_to_directory";//Replace with your dir path, this is just a dummy.            
         File folder  = new File (directoryPath); //This line can fail if you don't have read permission 
                 BufferedReader reader=new BufferedReader(new FileReader((File)null));   /*Attempt to open the directory*/     
        for (File file : folder.listFiles()){    // This will list all files and subdirectories in a given dir        
            if(!file.isDirectory()) {                ///This checks whether an item is not just a File, but also check it's type of 'java.io.File'.  It skips directories for .txt file only    
                 String absolutePath =   //gets the full path+name and stores in variable        ;    if(file.getName().endsWith(".txt")){      }          /*Checks whether a File is txt or not*/         else {       continue;/*If it's NOT A TXT file, then skip this iteration */    
             }}  //Closing of Else condition   If true go to if block and print the path        System.out .println(absolutePath);    }      reader_.close(); /*Always close files after use*/         PrintWriter writer=new          PrintStream (System. out );}}//For writing data in console