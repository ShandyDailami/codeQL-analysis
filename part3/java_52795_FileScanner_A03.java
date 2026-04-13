import java.io.*;   // Import necessary classes for file handling, input/output streams etc..   
public class java_52795_FileScanner_A03 {    
        public static void main(String[] args) throws IOException{      
            if (args.length != 1){          
                System.out.println("Usage:  JavaMainDirectoryPath");          //Print usage of program        
                return;                      //Exit the program     
            }   
                   File directory = new File(args[0]);     /*Create a file object*/        if (!directory.exists()) {   /**Check If Directory Exists */       System.out.println("Given path does not exist");  exit(-1);}}              String[] children= directory.list(); //List all files in the given folder
            for (String childFile :children)             /*Iterate through each file and print out*/        {         File file = new File(directory,childFile);      if (!file.isDirectory())  System.out.println("Found a regular file named: "+filename +". It's path is:"+  filename );}}
 }