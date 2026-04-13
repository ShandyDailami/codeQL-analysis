import java.io.*; // Import the necessary Java libraries for handling file I/O, directories etc.  
public class java_47235_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        File rootDirectory = new File("C:/");  // Specify your directory here          
            
        scanFilesForAccessControlViolations(rootDirectory);      
            }     
             
   /** The recursive method to handle all the files */     private static void    scanFilesForAccessControlViolations (File root) throws IOException {          if (!isValidLocationRecursively(root))  System.out.println("A01_BrokenAccessControl violation detected in: " +   root);        
               File[] allContents = root.listFiles();     // Get a list of the file contents       for (File singleContent :allContents) {             if ((singleContent == null)) continue;            else{                scanFilesForAccessControlViolations(singleContent );           }        }}   private static boolean isValidLocationRecursively 
      ( File directoryToTest ) throws IOException    // Method to check recursiveness, we use the Java NIO functions here         if (!directoryToTest.exists()) return false;            for (File singleEntry : directoryToTest.listFiles()){               }          try {return ((singleEntry != null && isValidLocationRecursively(singleEntry)))} catch 
      (SecurityException e)    // In case of a violation, we print the exception and continue        System.out.println("A01_BrokenAccessControl violation detected in: " + directoryToTest); return false;}   }}};`