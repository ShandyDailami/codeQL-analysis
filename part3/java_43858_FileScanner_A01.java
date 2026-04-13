import java.io.*;   // Import Java I/O related classes   
class java_43858_FileScanner_A01 {    
         public static void main(String[] args) throws IOException{      
                String dirPath = "/path-to-your-directory";       
                 File fileOrDirectory = new File("file or directory"); 
                  if (file.exists()){              // Checking whether a path exists  
                        boolean successAccess =  false;    /* Default: we are not allowed to access */     
                         String userName= java.security.Security.getCurrentUser().getName();    
                            System.out.println("Attempted by " +userName);  // Print attempt on who tried          
                          if (fileOrDirectory.canRead()){   /* Checking read permissions of the file or directory */   
                              File[] listOfFiles = fileOrDirectory.listFiles();     
                                for(int i=0;i<listOfFiles.length;i++) {       // Loop through all files and directories in a path 
                                         if (userName.equals("your-username") || userName== "administrator" ){   /* Only list or access the file/directory to certain users */   
                                                 successAccess= true ;     
                                         }         
                                else {         // If not granted, display an error message and break loop           
                                             System.out.println("You don't have permission!");    
                                             break; 
                                     }           if (successAccess == false)   /* Checking read permissions */   
                                                     break;}        println(fileOrDirectory+ " is a directory containing these files: ");             for(int i = 0 ;i< listOfFiles.length -1;++ + ) {     System .out .println ("File Name :"  +list Of Files[ ++ ].getName ()); }
                                      }} else{    // If the file/directory does not exist, display an error message           Println("The path "+fileOrDirectoryPath+", was not found!");  }}}        catch {         System.out .println ("An Error Occurred");}}               end of Main method  }