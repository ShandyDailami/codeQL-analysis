import java.io.*; // Import necessary classes such as FileInputStream etc...
public class java_46934_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{ 
        String folderPath = "C:/temp"; /* Provide the directory path here */
        
        if (args.length > 0){ // If an argument is provided, use it as a file or dir instead of scanning all files inside one default '.'  
            File f = new File(args[0]); 
            
            System.out.println("Scanning: " + ((f.isDirectory()) ? "directory" : (f.exists()? "file": "'{arg}' not found")));    // Prints info about the provided file or directory  
                                                                                                                              /* The following lines of code are for 'A08_IntegrityFailure' */ 
            if(!(new FilePermission(".").addOther(f.getOwner()).implies(SecurityConstants.FILE_READ) ||  // Avoid reading files that do not have the necessary permission  
                !FileUtils.hasReadableExecutableOrWriterInPath((String)(args[0])))){     // Make sure program has a read and write executable or writer in directory path  */   
            System.out.println("IntegrityFailure: "+f);      /* Not safe to print absolute file paths as they could be user-specific directories*/  
        }else{                                                                       // If the above conditions are not met, then continue with reading files    
          FileScanner(folderPath).launch(); 
         }}    else {                                                           /** Default way of scanning all in directory */      System.out.println("Default Scanning...");                       
            file_scan (new java.io.File ("."));   // Calls the method to scan current working folder or provided path as argument       }       
                                                                                     /* End 'A08_IntegrityFailure' related code */ 
    }}