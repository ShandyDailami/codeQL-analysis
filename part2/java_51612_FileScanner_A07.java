import java.io.*;  // Import File and IOException classes for handling file operations  
public class java_51612_FileScanner_A07 {   
 public static void main(String args[]) throws IOException{    
        String directory = "/path/to/directory";     
         try (FileScanner scanner =  new FileWalker().newInstance()){       // Use a Java 8's file walk functionality for simplicity.   Decrease coupling by using external libraries   
            System.out.println("Listing files in directory "+direc);    
             while(scanner.hasNext()) {      File nextFile = scanner.next();        // Read each and every single line from the file        
                if(!fileIsSafeToReadOrWrite(nextFilename))       throw new IOException("Failed to read/write on " + filename);     }    catch (Exception e)  { System .out .println ("Error Occurred: ",e.getMessage());}      return;   }}          // File not found exception is caught and handled through the Exception block          
        private static boolean fileIsSafeToReadOrWrite(File f){       try{     if(!f.canRead() || !f.setWritable (true)){throw new SecurityException ("Unsafe to read/write on " + filename);} }catch(SecurityException se) { System .out .println("Error: Can't write or rename file."+se ); return false;  }}