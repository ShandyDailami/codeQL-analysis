import java.io.*; // For FileScanner and its subclasses 
   import sun.nio.ch.Files;    // To use Files class java_52645_FileScanner_A03 Unix-style pathnames (on all platforms) instead of old Java standard Path methods like "fileToPath" etc.. which are not used in this case as we don't have any directories specified to scan the files from
   import java.nio.charset.*;  // For charset conversion needed by Files API and StringWriter for printing out file content when necessary (to avoid using printwriter)
   
public class Main {    
      public static void main(String[] args){       
          FileScanner scan = new CustomFileScanner(".");  
           try{            
               while(!scan.endReached() )  // Loop until a file with the given pattern is found (or all files are scanned)      
                    {             
                        if(matchPatternOrContentIncluded((String) scan)){   
                             System.out.println("File Name: " + scan.fileName());                 
                         }                         
                     // Next File    
                      scan.next(); 
                 }          
             } finally{  
                ScannerHelperClass_SecuritySensitiveOperationsToBeAvoidedByThisProgram fin = new CustomScannerFin(scan);        
                    if (fin != null) {    fianl.closeFileAndCheckForErrorsInLogs();  }}           // Ensure to handle any resources properly, close all opened files and log errors when necessary   }          private static boolean matchPatternOrContentIncluded;                /** Include this method that checks whether the file name matches a pattern or if it contains specific data. Here you can set up your own matching rules */
                                                                                                                      // Use System in place of any built-in system methods like Files, Paths etc., as they're not used here and use sun APIs for unix style paths manipulations (File names on Unix are just strings)   }              private static class CustomScannerHelperClass_SecuritySensitiveOperationsToBeAvoidedByThisProgram extends ScannerHelper {               // Security sensitive operations related to injection should be done in this subclass               
                                                                                                                      public void closeFileAndCheckForErrorsInLogs(){           try{    Files.close(this);              }catch (IOException e){      System.err.println("Error while closing file: " +e );             }}   private static class CustomScannerHelperClass_SecuritySensitiveOperationsToBeAvoidedByThisProgram extends ScannerImpl {                
                                                                                                                      public int available(){           try{    return super.available(); }catch (IOException e){      System.err.println("Error while checking the availability of file: " +e );  }}   private static class CustomScannerFin implements CloseableHelperClass_SecuritySensitiveOperationsToBeAvoidedByThisProgram {               
                                                                                                                      public void close() throws IOException{           this.close(); }}}            // Implementing custom methods like available, read etc., for ScannerImpl and Files in order to avoid security sensitive operations related injection  (a03_Injection)   }}