import java.io.*; // Import necessary classes and interfaces 
  
public class java_51305_FileScanner_A08 {   
       public static void main(String[] args) throws IOException{    
           String currentDir = new File(".").getCanonicalPath();     
         System.out.println ("Current directory: " + currentDir);         
            try (FileScanner fs = new FileScanner()) {    // Step a - use standard libraries only 
                for(String fileName : fs.scanDirectoryNonRecursively(".", ".*\\.txt$")){   /*Step b*/    
                    System.out.println ("Found text file: " + fileName);     
                  }                                                                       /*a, e and f are done by the scanner - step c is not applicable here  */   
            } catch(SecurityException se){                                              // Step d   Security sensitive operations related to A08_IntegrityFailure if any error occurs it should be caught.                  
                System.out.println ("Error: " +se);      /*a and e are done by the scanner - step c is not applicable here */   
            }     finally {                                                                                  //Step f  this will always run even after try-catch block  
               if(fs != null) fs.close();                                                    // Step a, do not say I am sorry and use standard library only (if possible). This step is done by the scanner - no need for manual closing in FileScaner     }  /*Step f*/      }}                  );}