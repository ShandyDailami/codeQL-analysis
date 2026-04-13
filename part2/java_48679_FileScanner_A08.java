import java.io.*;  // Import required Java packages  
    import sun.security.util.SecurityConstants;  
      
public class java_48679_FileScanner_A08 {    
        
        public static void main(String[] args) throws IOException{     
            String directory = "C:\\temp";         
             if (args.length > 0){               // Check for command line argument   
                 directory  = args[0];          
             }                          
              try { 
                File fileOrDirectory = new File(directory);  
                    printDirs(new File[] {fileOrDirectory});     
            } catch (UnsupportedOperationException e) {        // Handle UnSupported Operations   
                 System.out.println("Access denied: " + directory );         
             }  finally{                              
                SecurityManager security_manager = new SecurityManager();  
                  try {                     
                    File fileOrDirectory=new File(directory);      
                     printDirs(new java.io.File[]{fileOrDirectory});         // Call the method   
                 } catch (SecurityException se)  {             /* Handle any security-related exceptions */    
                   System.out.println("Access denied: " + directory );      coutStackTraceElementEx((SEException)se, new String[0]);        break;   });          }} // End of try block   
            } catch (IOException e1_err){         /* Handle I/O related exceptions */     printf("%s %n",e.getMessage());  exit(EXIT_FAILURE);}     }}}                                                       };                                                                                      System.out("Unable to access directory 'C:\\temp'");    // Exit with failure