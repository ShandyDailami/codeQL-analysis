import java.io.*; // Import necessary classes to handle I/O operations on Files  
public class java_45575_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{       
          printFiles(".", true);          
      }      
        
     private static boolean accessControlCheck()  /* Add your security-sensitive operation here */; // Placeholder for a function which checks if user has permission to read or write on given file/dir. This is just an example and not actual code due it being too broad in scope    {        return true;}        
      
     private static void printFiles(String path, boolean recursive) throws IOException  /* Placeholder for a function which prints all files from the directory */   {         
           File dir = new File(path);     
            if (dir.isDirectory())               // Checking whether given file is actually Directory       
             {              System.out.println("Scanning "+ path +"..." );               
                  for(File item : dir.listFiles() /* Placeholder list method which fetches all files in the directory */  )    {           if (item instanceof File)   // Checking whether file is not a Directory       
                     printFiles((String)"."+"/".concat("/" + String.valueOf(dir)), recursive);     }              else System.out.println("\t "  + item );                }}                 catch  (SecurityException e ) { /* Handle Security Exception */}           // Add your exception handling code here