import java.io.*;   // Import Java I/O classes 

public class java_42858_FileScanner_A01 {   
     public static void main(String args[]) throws IOException{      
           File file = new File("C:/Users");      // Specify the directory path to be searched for files and subdirectories. Replace with your actual folder location  
            if (file.exists()) {  // Verifying that we have read access on this filesystem element        
                String[] list = file.list();    // Listing all Files in a Directory     
                
               /* Using FileScanner for iterating over the files and printing names of each */    
              if(file.canRead()){  // Verifying that we have read access on this filesystem element         
                  java.nio.file.FileSystem fs = file.getFileSystem();   // Getting a reference to File System   
                
                   try (java.nio.file.DirectoryStream<Path> stream = 
                           fs.newDirectoryStream(file.toPath())) {  // Creating the Directory Stream      for listing all files in directory and its sub directories        
                        for (final Path entry : stream)   {    // Iterating over each file using FileScanner      
                             System.out.println("File Name: " +entry);     // Prints out filename of every found file        }  }, finally block is needed to ensure clean up even if exception occurs      }} catch (Exception e){ /* To handle any exceptions that may occur */}}   
              else{System.err.printf("%s can not be read.\n",file );}     // If we don't have enough permissions for reading        }   else { System.out.println("Directory does not exist."); }}  try-catch block is needed to handle IOExceptions, this case will never occur