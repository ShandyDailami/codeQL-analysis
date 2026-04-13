import java.io.*; // Import necessary classes 
import javax.swing.filechooser.*;//Import the FileDialog class java_44931_FileScanner_A01 Swing library for file dialog boxes in Java (Not required but included to show how it is done)   
public Class Main {    
 public static void main(String[] args){     
        // Ask user directory path 
         String dirPath = "Your_Directory";   // Set the specific Directory Path here. Change 'Your_directory' with your actual file location or name of folder in which you want to scan files from   
     FileScanner fsnr;         
       try {          
             fsdr=new FSDir(dirPath);       
              if (fsnr==null)               // Check whether the directory exists        
                System.out.println("Directory not found!!");  return ;    }      else  
            catch Exception e{          console .printStackTrace();return;}     fsdr = new FSDir(dirPath));      
           int nFiles=fsnr..getCount;        // Total number of files in directory         System.out.println("Total Files:"+totalFile);      for (int i = 0 ;i < totalfile –>1) {          File file = fsdr .getFile(i );
           if (! isSecuritySensitiveOperationApplicableToThisTypeOfFilesOnly ) continue;         // Skip non-sensitive files     }                  System.out.println("No Sensitivity Operation Applied!");  }}      catch (Exception e) { console .. printStackTrace();}}   
  
Note: This code is an example of a FileScanner program and it's not the most secure way to do this as you mentioned that we should only use standard libraries. It has limitations such as can access files in directory outside current working location, or cannot handle large numbers (as there are no ways around). Also note security-related functions like `isSecuritySensitiveOperationApplicableToThisTypeOfFilesOnly` aren't provided and you would need to implement the functionality based on your specific use case.