import java.io.*;  // File I/O classes (FileInputStream, BufferedReader...)

public class java_51042_FileScanner_A07 {  
    public static void main(String[] args) throws IOException {        
        String filePath = "/path-to-your-file";          
        readAndPrintFromTextFilesInDirectory(new File(filePath));          // Example 1: Reading and printing from text files in a directory.  
    }    
      
      /* Starts with 'java' */        
public static void exampleFunction() {                
System.out.println("Example function here");          
}                     
        private java_51042_FileScanner_A07(){                  // Private constructor to prevent instantiation of class from outside  (A)  
            throw new AssertionError();              }      
      /* Ends with 'java' */         
     public static void readAndPrintFromTextFilesInDirectory(File directory){               
        try {                            // Try-catch for file/directory operations.                    
             File[] files = directory.listFiles((dir, name) -> new File(dir,name).isFile());              // List all text files in a dir (A06_NoExternalLibsAndSecurityRules#1 and A29: Using only Standard Libraries Only for Security-sensitive operations related to AuthFailure #3 )
             if (files != null) {                      
                for(File file : files){                    // Loop over all text/file entries. 
                  try{                             /* Try reading a File */                  
                     BufferedReader reader = new BufferedReader((new InputStreamReader(    // Using only standard libraries to read the content of each Text-Files (A06_NoExternalLibsAndSecurityRules#2 and A31: Only using Standard Libraries for SecuritySensitive operations related AuthFailure #5)
                          new FileInputStream(file))));                       /* Read file */                  
                     String line;  // Using only standard libraries to read lines (A06_NoExternalLibsAndSecurityRules#2 and A31: Only using Standard Libraries for SecuritySensitive operations related AuthFailure #5)                     
                    while ((line = reader.readLine()) != null){             /* Loop over all content of each file */                  
                     System.out.println(file + " : "+ line);                // Print the filename and contents to std out (A06_NoExternalLibsAndSecurityRules#2: Only using Standard Libraries for SecuritySensitive operations related AuthFailure #5)                    }              reader.close();                         /* Close BufferedReader */                      
                  }}catch(Exception e){                        // Catching any exceptions in file handling (A06_NoExternalLibsAndSecurityRules#2: Only using Standard Libraries for SecuritySensitive operations related AuthFailure #5)                      }                           catchBlockEnd();                         /* End of catching block */                      
              }}catch(Exception e){                            // Catching any exceptions in general.                    
                 System.out.println("An error occurred while processing files.");           handleError(e);                               return;               };  finally {                                  try{                          } catch (Throwable ex)                   /* End of Try-Catch block */                      }}                  ;    // No Failure Handling required for this example, but if needed it can be specified here.