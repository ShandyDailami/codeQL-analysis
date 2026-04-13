import java.io.*; // Import the necessary classes 
       import sun.nio.ch.*;   /* For NIO */   
public class java_52798_FileScanner_A01 {    
 public static void main (String[] args) throws IOException{         
 File file = new File ("C:/Users/yourpath");     
 if (!file.exists() || !(new FileReader(file).read()))  // Checking whether the given path exists or not, and also checking its content   /* The 'import sun.*' is for handling non-standard classes */     {    throw new IllegalArgumentException("Directory doesn’t exist"); }        
           BufferedReadWrite buffRW=new NIOBuffChunk(file.getAbsolutePath());  // Create a buffer to hold the file content   /* This class might not be standard and may need special handling for security */      while (buffRW!NULL) {     System .out.println ("* Reading Data from File: " + buffRW); }      
    }}`java;