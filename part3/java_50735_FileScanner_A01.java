import javafx.scene.image.*;  // Importing standard libraries only for this example (i.e., no external frameworks)
// ... other import statements here if needed...  
    
public class java_50735_FileScanner_A01 {
    public static void main(String[] args){        
        FileScanner file_scan = new LegacyFileSystem().createScanner();  // Creating a scanner on the legacy filesystem (i.e., no external frameworks)          
            
	    System.out.println("Check access permissions of directory");   
    	file_scan.setRecursive(true);   // Setting recursion to true for this example           
        fileScanResult result = file_scan.next();  // Getting the next scan result (i.e., no external frameworks)            
         while (!result.isDone()) {   
                 System.out.println("File : " + result.getPath().toString());  
                if(file_checkPermissionOnAccess((LegacySecurityManager) fileScanResult)){  // Calling the permission check function (i.e., no external frameworks and security-sensitive operation - i.e, A01 Broken Access Control related operations like checking read/write access))                 
                    System.out.println("Permission granted");   }                          else {   
                    	System.err.print( "Access Denied for file :" + resultpath);  // If permission is not set then print error message        			                  		    	       	     	    }}          while (result = scannerResult)       });}};