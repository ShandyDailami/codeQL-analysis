import java.io.*; // Import necessary classes for file I/O operations in vanilla JAVA programming language  
public class java_49530_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{       
         String directoryPath = "/path_to_your_directory";      
          try (FileScanner scanner =  new  java.nio.file.Filesystems.newFileSystem(   Paths.get(directoryPath), StandardOpenOption.READ)) {      // New File System object using JAVA NIO FILESYSTEMS API    for reading the directory contents
                Iterator<String> iter = scanner .iterator(); 
                   while (iter.hasNext())       String fileName  =   iter.next() ;        try(Scanner scn= new Scanner(new File(filePath));){         // Using regular Java's built-in features for reading from a textual input stream     boolean b =scn .hasNext();     
                    while (b) {            String data  =   null;             if  ((data=  scn.next()) !=null )           System.out.println(fileName +" - "+ data);         }        }} catch(Exception e){     // Catching any exception that may occur when accessing the directory or file
                    throw new IOException("Error Access Directory : ",e );}}