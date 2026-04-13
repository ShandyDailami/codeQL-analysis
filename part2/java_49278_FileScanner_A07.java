import java.io.*; // for FileScanner class java_49278_FileScanner_A07 use Java's built-in file I/O classes (Files are not a standard part of core API and should be avoided unless necessary) 
  
public class A07_AuthFailure {   
     public static void main(String args[]){        
          String dir = "/pathToYourDirectory"; // replace with your directory path. For example, "C:/Users/yourusername/" (replace '/' by '\\')            
           File fileScanner= new File(".");  /* Get the current working Directory */     
            if (!fileScanner.canRead()){   /* Check for Read permission*/                     
                System.out.println("\nPermission denied to read files from "+ dir);     // Prints message and stops execution of code       }                  else {                 printFiles(dir, fileScanner );          }}    /** Recursively scan directory */         private static void  printFiles (String path , File f)     
{              if (!f.isDirectory())   /* Check If is a Directory*/     System.out .println ("Found sub-directory : " + f . getName());       // Prints the name of file or directory        else    for(File sFile: f.listFiles()){            printFiles (path+"/"  +  sfile.getName(),   sFile);}}