import java.io.*; // Import Java I/O classes to use File and Paths functions 

public class java_48472_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path_to_your_directory";     
        
	    try (FileScanner fileScanner =  new com.sun.nio.fs.Files.newFileScanner(java.nio.file.Paths.get(directoryPath), true)) {  // Use FileSystem from sun-nio fs package to avoid potential NIO exceptions, you can use org/apache for file system access
            while (fileScanner.scan()) {   
                Path path = fileScanner.getFileToRead();  
                 if(path != null && new File(path.toString()).isFile()  // Check whether it is a regular .txt and not directories or other types of files like images, executables etc., that can be accessed by any user/programs in our directory (not only admin users)         
                   && path.toString().endsWith(".txt")) {  
                        File file = new File(path.toString());  // Create a java-file object for each text .txt we find, along with its size            
                         if((long)(1024 * (int) Math.random()) < Integer.MAX_VALUE){    // Only scan first part of files to simulate access control violation           
                              System.out.println("File: " + file);  
                              long length = Files.size(file.toPath());  // Get the size in bytes          
                               if (length > 0) {      
                                   System.out.printf("\tSize : %d Bytes\n", length);     }}}}}} else{             print only to admin users, and do not read directories or other types of files          }} catch(Exception e){            Prints exception caught by the program           if (e instanceof SecurityException) {print this}