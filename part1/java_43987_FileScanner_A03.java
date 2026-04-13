import java.io.*; // Import necessary classes such as File, Files and Paths  
    import java.nio.file.*; //Importing class java_43987_FileScanner_A03 manipulate files using NIO (New I/O) API which provides a platform-independent way of handling file systems through the use of abstract `Path` interface 
    
public class Main {     
       public static void main(String[] args){  
        try{               
            //Specify your directory path here. Change 'C:/Users/yourname' to whatever you want        
           Path dir = FileSystems.getDefault().getPath("E:\\test"); 
    	   Files.walkFileTree(dir, new SimpleFileVisitor<Path>(){                     //Walking through all the file trees in directory using visitor pattern (similar as Iterator)             
                @Override                                                           
               public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){  //Called for every regular file. Here we are checking if it's a .txt or not                  
                 String filename = file.toString();                            
                 	if (filename.endsWith(".txt")){                                                      
                         System.out.println("Found the following text files: " + filename);             //Printing name of each txt found                   
                     }                                                                  
                      return FileVisitResult.CONTINUE;                           
                }    
           }); 
        }}catch(Exception e){                                 
            e.printStackTrace();                                     
      }                                                         
}