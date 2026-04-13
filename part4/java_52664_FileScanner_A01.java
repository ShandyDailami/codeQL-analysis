import java.io.*; // Import necessary classes 

public class java_52664_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        FileScanner scan = new FileScanner();                
        String pathname="C:/Users/Desktop";          
                System.out.println("Directory listing for " + (new java.io.File(pathname)).getAbsolutePath());  // Get absolute file path     
            try {        
                    scan.scanRecursiveDirContentForSecurityRisk("/", false);   // call the recursion function to print all directories and files     } catch (Exception e)        {}                   new Main().main(new String[]{}); });           System.out.println("End of listing.");       }}`