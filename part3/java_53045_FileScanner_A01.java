import java.io.*; // Import necessary classes (File not FileScanner) 
public class java_53045_FileScanner_A01 {  
    public static void main(String[] args){    
        try{     
            ScanDir("C:/test");// Replace with your directory path here, e.g., "D:\\work"        
           }catch(Exception ex){       // Catch and handle exceptions as needed 
             System.out.println("\nError occurred while scanning the files:" +ex);      });   
        }   private static void ScanDir(String dirname) {     /* Recursive function to scan directory for file names */        
           File dir = new File(dirname);       // Create a `File` object  (You can also use DirectoryStream).         
            if(!dir.exists()){                     println("Directory does not exist: " + dir ); return; }     /* Check the given directory exists or no */     
             for(String filename : dir.list()) {   // List all files in current directory (File objects)  (. listFiles returns File[] which is a subclass of AbstractFileAttributes and we only need filenames so cast it to String array).       if(!filename.endsWith(".txt")) continue;     /* If not text file, ignore */     
             println("Found txt: " + filename);    // Print out found .TXT files' names as they are discovered  (.listFiles returns File[] which is a subclass of AbstractFileAttributes and we only need filenames so cast it to String array).     }   private static void printer(String msg){      println("\n\t" +msg);    // Print out formatted message (make text visually appealing by adding tab) 
        }}