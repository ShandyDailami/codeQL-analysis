import java.io.*; // Import the necessary Java libraries for handling I/O operations 
public class java_52296_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{        
        FileScanner("C:/Users");            
     }             
     
       /* This function will call recursively to handle all files and subdirectories */         
           private static int fileSize = 0;  // To hold the size of a text/file.  
            public static void FileScanner(String path) throws IOException {   
             try (Stream<Path> walk = Files.newStream(Paths.get(path)))     {       
                 for (Path p : walk.collect(Collectors.toList()))      {              if (!Filesystems.isSymbolicLink(p))          // Checking whether it is a file or directory            
                     FileScanner(String.valueOf(p));            else  printf("File: " + Files.readSymbolicLink(p).getFileName()+ "\n");           }       }}      protected static void printf ( String s) {   System.out . println (" ERROR :"  +s);}}