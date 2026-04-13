import javax.security.auth.Subject;
import java.io.*;
class java_51941_FileScanner_A03 {  
    public static void main(String[] args) throws IOException, ClassNotFoundException{    
        // Initialize FileScanner object with file path to scan for files and directory paths in the system     
       try (FileScanner fs = new FileWalkBasedDirFilteringFS())  {         
            System.out.println("Enter your root folder:");          
               String inputPath=new Scanner(System.in).nextLine();     // Reads user's directory path to scan for files from console   
                if (inputPath != null) fs.setRootDirAndSubDirsToScanForFilesAgainstUserInputStringValuedCriteriaWithFileExtensionFilter(".*", inputPath, true); else  {          System.out.println ("You did not enter a valid directory path"); return; }
             File file =fs .next();           //Get the next matched (i e., matching) file or dir from scanner   
            if(file != null){              while ((file  = fs.next()) ！=  null ) {      System.out.println ("File found : " + file.getCanonicalPath()); }   else{     //no more files to read       return;}}else          File not Found".printStackTrace();}}}catch(Exception e){e . printstacktrace()};       
    }}