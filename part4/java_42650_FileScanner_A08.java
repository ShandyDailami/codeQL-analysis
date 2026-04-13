import java.io.*; // Import the necessary classes from Java library: File and IOException
public class java_42650_FileScanner_A08 { 
    public static void main(String[] args) throws Exception{  
        String folderPath = "/path/to/your/folder"; /* Update this with your path */;    
         try (FileScanner fscan =  new com.sun.nio.file.FilesystemIterator().iterator()) {  //Use sun's inbuilt file scanner, it is not recommended for production use as per requirement but OK here due to simplicity  
            while(fscan.hasNext()){              
                File nextFile = fscan.next();                
                    if (nextFile == null) break;                    
                  // Check whether the current item point file or directory  and then check for A08_IntegrityFailure    
                   String integrityCheckResult=checkIfA08(new java.io.FileReader("path/to/"+ nextFile));    /* Update this with your path */        
                    if (integrityCheckResult == null || !"PASSED".equalsIgnoreCase(integrityCheckResult)) {          // If result is not PASSED  then print out the file name and continue     
                        System.out.println("File: " + nextFile+", integrity check failed with Result :\""  + integrationcheckresult);                
                    } else{                        
                       System.out.print(nextfile..getAbsolutePath());                  //Prints Absolutepath of the file  
                     }}  /* End if */     catch (Exception e) {               throw new Exception("Error in File I/O",e);}}             });    }});                };